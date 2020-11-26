package com.javarush.task.task30.task3008;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
//        ConsoleHelper.writeMessage("Введите порт сервера:");
//        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(10)) {
            ConsoleHelper.writeMessage("Чат сервер запущен.");
            while (true) {
                // Ожидаем входящее соединение и запускаем отдельный поток при его принятии
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервера.");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с " + socket.getRemoteSocketAddress());

            String userName = null;

            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);

                // Сообщаем всем участникам, что присоединился новый участник
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                // Сообщаем новому участнику о существующих участниках
                notifyUsers(connection, userName);

                // Обрабатываем сообщения пользователей
                serverMainLoop(connection, userName);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с " + socket.getRemoteSocketAddress());
            }

            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }

            ConsoleHelper.writeMessage("Соединение с " + socket.getRemoteSocketAddress() + " закрыто.");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));

                Message message = connection.receive();
                if (message.getType() != MessageType.USER_NAME) {
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
                    continue;
                }

                String userName = message.getData();

                if (userName.isEmpty()) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с пустым именем от " + socket.getRemoteSocketAddress());
                    continue;
                }

                if (connectionMap.containsKey(userName)) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с уже используемым именем от " + socket.getRemoteSocketAddress());
                    continue;
                }
                connectionMap.put(userName, connection);

                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return userName;
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (name.equals(userName))
                    continue;
                connection.send(new Message(MessageType.USER_ADDED, name));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT) {
                    String data = message.getData();
                    SimpleDateFormat format = new SimpleDateFormat("H:mm:s");
                    sendBroadcastMessage(new Message(MessageType.TEXT, format.format(new Date())
                            + " " + userName + ": " + data));

                } else if (message.getType() == MessageType.PRIVATE_MESSAGE) {
                    String nameUserTo = message.getUserName();
                    String nameUserFrom = message.getUserNameSource();
                    String data = "Личное сообщение от " + nameUserFrom + ": " + message.getData();
                    sendPrivateMessage(new Message(MessageType.TEXT, data), nameUserTo);

                }else if (message.getType() == MessageType.FILE) {
                    String nameUserTo = message.getUserName();
                    String nameUserFrom = message.getUserNameSource();
                    String data = message.getData();
                    connection.getRemoteSocketAddress().toString();
                    BufferedWriter writer = new BufferedWriter(new FileWriter("D:\receiveFile.txt"));
                    writer.write(data);
                    sendFile(new Message(MessageType.FILE, data), nameUserTo);
                    sendBroadcastMessage(new Message(MessageType.TEXT, connection.getRemoteSocketAddress().toString()));

                } else if (message.getType() == MessageType.USER_ADDED) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, "Присоединился новый пользователь "));
                } else {
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        // Рассылаем сообщение по всем соединениям
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение " + connection.getRemoteSocketAddress());
            }
        }
    }

    public static void sendPrivateMessage(Message message, String userName) {
        for (String name : connectionMap.keySet()) {
            if (name.equals(userName)) {
                try {
                    connectionMap.get(userName).send(message);
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Не смогли отправить сообщение " + connectionMap.get(userName).getRemoteSocketAddress());
                }
            }
        }
    }

    public static void sendFile(Message message, String userName) {
        for (String name : connectionMap.keySet()) {
            if (name.equals(userName)) {
                try {
                    connectionMap.get(userName).send(message);
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Не смогли отправить сообщение " + connectionMap.get(userName).getRemoteSocketAddress());
                }
            }
        }
    }
}
