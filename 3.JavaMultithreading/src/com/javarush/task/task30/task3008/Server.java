package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не было отправлено");
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        try (ServerSocket server = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Сервер запущен!");
            while (true) {
                Socket socket = server.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message receive;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                receive = connection.receive();
                if (receive.getType().equals(MessageType.USER_NAME) && receive.getData() != null &&
                        !connectionMap.containsKey(receive.getData()) && !receive.getData().equals("")) {
                    break;
                }
            }
            connectionMap.put(receive.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return receive.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, name));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                else ConsoleHelper.writeMessage("Сообщение не является текстом");
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение c " + socket.getRemoteSocketAddress());
            Connection connection = null;
            String userName = "";
            try {
                connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connection.close();
                for (String names : connectionMap.keySet()) {
                    if (names.equals(userName)) {
                        connectionMap.remove(userName);
                        sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                    }
                }
                ConsoleHelper.writeMessage("Соединение закрыто");
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }
        }
    }
}
