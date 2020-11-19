package com.javarush.task.task30.task3008.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ClientGuiView {
    private final ClientGuiController controller;

    private JFrame frame = new JFrame("Чат");
    private JTextField textField = new JTextField(50);
    private JTextArea messages = new JTextArea(30, 60);
    private JTextArea users = new JTextArea(10,10);
    private JButton send = new JButton("Send");
    private JButton reset = new JButton("Reset");
    private JButton name = new JButton();
    private JLabel label = new JLabel("Enter text");
    private JMenuBar menuBar = new JMenuBar();
    private final JTabbedPane tabbedPane = new JTabbedPane();

    public ClientGuiView(ClientGuiController controller) {
        this.controller = controller;
        initView();
    }



    private void initView() {
        textField.setEditable(true);
        messages.setEditable(false);
        messages.setLineWrap(true);
        users.setEditable(false);

        // Добавление в главное меню выпадающих пунктов меню
        frame.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(new JMenu("Help"));

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        frame.getContentPane().add(panel1, BorderLayout.NORTH);
//        frame.getContentPane().add(menuBar, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(messages), BorderLayout.WEST);
        frame.getContentPane().add(new JScrollPane(users), BorderLayout.EAST);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
        panel1.add(tabbedPane, BorderLayout.WEST);
        panel.add(label);
        panel.add(textField);
        panel.add(send);
        panel.add(reset);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);


        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.sendTextMessage(textField.getText());
                textField.setText("");
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.sendTextMessage(textField.getText());
                textField.setText("");
            }
        });
    }

    public String getServerAddress() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите адрес сервера:",
                "Конфигурация клиента",
                JOptionPane.QUESTION_MESSAGE);
    }

    public int getServerPort() {
        while (true) {
            String port = JOptionPane.showInputDialog(
                    frame,
                    "Введите порт сервера:",
                    "Конфигурация клиента",
                    JOptionPane.QUESTION_MESSAGE);
            try {
                return Integer.parseInt(port.trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Был введен некорректный порт сервера. Попробуйте еще раз.",
                        "Конфигурация клиента",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getUserName() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите ваше имя:",
                "Конфигурация клиента",
                JOptionPane.QUESTION_MESSAGE);
    }

    public void notifyConnectionStatusChanged(boolean clientConnected) {
        textField.setEditable(clientConnected);
        if (clientConnected) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Соединение с сервером установлено",
                    "Чат",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    frame,
                    "Клиент не подключен к серверу",
                    "Чат",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void refreshMessages() {
        messages.append(controller.getModel().getNewMessage() + "\n");
    }

    public void refreshUsers() {
        ClientGuiModel model = controller.getModel();
        StringBuilder sb = new StringBuilder();
        for (String userName : model.getAllUserNames()) {
            name.setName(userName);
            name.setSize(90,20);
            name.setFont(new Font("Verdana", Font.PLAIN, 12));
            users.add(name);
            name.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextArea privateChat = new JTextArea(10,60);
                    tabbedPane.addTab(userName, privateChat);
                    messages.setVisible(false);
                    messages.setRows(0);
                    textField.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            controller.sendTextMessage(textField.getText());
                            textField.setText("");
                        }
                    });
                }
            });
//            sb.append(userName).append("\n");
        }
//        users.setText(sb.toString());
    }

    private JMenu createFileMenu() {
        // Создание выпадающего меню
        JMenu file = new JMenu("Файл");
        file.setMnemonic('Ф');
        // Пункт меню "Открыть" с изображением
        JMenuItem open = new JMenuItem("Открыть",
                new ImageIcon("images/open.png"));
        open.setMnemonic('О');
        // Пункт меню из команды с выходом из программы
        JMenuItem exit = new JMenuItem("Выход");
        exit.setMnemonic('X');
        // Добавление к пункту меню изображения
        exit.setIcon(new ImageIcon("images/exit.png"));
        // Добавим в меню пункта open
        file.add(open);
        // Добавление разделителя
        file.addSeparator();
        file.add(exit);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = null;
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    file = fileopen.getSelectedFile();
                    textField.setText(file.getName());
                }

            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Да", "Нет!"};
                int n = JOptionPane.showOptionDialog(frame, "Закрыть окно?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    System.exit(0);
                }
            }
        });
        return file;
    }
}
