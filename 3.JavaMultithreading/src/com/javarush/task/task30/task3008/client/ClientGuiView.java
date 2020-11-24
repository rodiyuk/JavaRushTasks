package com.javarush.task.task30.task3008.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ClientGuiView {
    private final ClientGuiController controller;

    private JFrame frame = new JFrame("Чат");
    private JTextField textField = new JTextField(40);
    private JTextArea messages = new JTextArea(30, 60);
    //    private JPanel users;
    private JPanel users = new JPanel(new VerticalLayout());
    //    private JTextArea users = new JTextArea();
    private JButton send = new JButton("Отправить");
    private JButton reset = new JButton("Сбросить");
    private JButton clear = new JButton("Очистить чат");
    private JButton name;
    private JLabel label = new JLabel("Enter text");
    private JMenuBar menuBar = new JMenuBar();
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private static volatile boolean isPrivate = false;
    //    private JTextArea privateChat = new JTextArea(10, 60);
    public static volatile int index = -1;

    public ClientGuiView(ClientGuiController controller) {
        this.controller = controller;
        initView();
    }


    private void initView() {
        frame.setSize(850, 600);

        if (!isPrivate) tabbedPane.setVisible(false);
        textField.setEditable(true);
        messages.setEditable(false);
        messages.setLineWrap(true);
//        users.setEditable(false);
//        users.setLayout(new VerticalLayout());

        // Добавление в главное меню выпадающих пунктов меню
        frame.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(new JMenu("Help"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(send);
        panel.add(reset);
        panel.add(clear);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);

        JPanel panel1 = new JPanel();
        panel1.add(tabbedPane, BorderLayout.WEST);
        panel1.setLayout(new BorderLayout());
        frame.getContentPane().add(panel1, BorderLayout.NORTH);

        frame.getContentPane().add(new JScrollPane(messages), BorderLayout.WEST);

        frame.getContentPane().add(new JScrollPane(users), BorderLayout.CENTER);
//        frame.pack();
//        frame.repaint();
//        frame.revalidate();

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
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messages.setText("");
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
        users.removeAll();

        for (String userName : model.getAllUserNames()) {
            model.addUser(userName);
            users.add(addUsers(userName));
        }
        frame.pack();
    }

    private JButton addUsers(String userName) {
        name = new JButton(userName);
        name.setFont(new Font("Verdana", Font.ITALIC, 15));
        if (userName.equalsIgnoreCase(controller.name))
            name.setBackground(Color.pink);
        name.setCursor(new Cursor(Cursor.HAND_CURSOR));
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = name.getX();
                int y = name.getY() + name.getHeight();
                JPopupMenu jPopupMenu = new JPopupMenu();
                JMenuItem privat = new JMenuItem("Личное сообщение");
                JMenuItem block = new JMenuItem("Заблокировать пользователя");
                jPopupMenu.add(privat);
                jPopupMenu.add(block);
                jPopupMenu.show(users, x, y);
                if (userName.equals(controller.name)) {
                    privat.setEnabled(false);
                    block.setEnabled(false);
                }

                privat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        index++;
                        JTextArea privateChat = new JTextArea(10, 55);
                        isPrivate = true;
                        tabbedPane.setVisible(true);
                        privateChat.setEditable(false);
                        tabbedPane.addTab(userName, new JScrollPane(privateChat));
                        tabbedPane.setSelectedIndex(index);
                        messages.setRows(5);
                        textField.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                controller.sendPrivateTextMessage(textField.getText(), userName, controller.name);
                                int select = tabbedPane.getSelectedIndex();
                                privateChat.append(textField.getText() + "\n");
                                textField.setText("");
                            }
                        });
                    }
                });
            }
        });
        return name;
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
                    if (file.length() / (1024 * 1024) > 5)
                        JOptionPane.showMessageDialog(frame,
                                "Размер файла превышает 5мб",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                    else textField.setText(file.getName());
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

    class VerticalLayout implements LayoutManager {
        private Dimension size = new Dimension();

        // Следующие два метода не используются
        public void addLayoutComponent(String name, Component comp) {
        }

        public void removeLayoutComponent(Component comp) {
        }

        // Метод определения минимального размера для контейнера
        public Dimension minimumLayoutSize(Container c) {
            return calculateBestSize(c);
        }

        // Метод определения предпочтительного размера для контейнера
        public Dimension preferredLayoutSize(Container c) {
            return calculateBestSize(c);
        }

        // Метод расположения компонентов в контейнере
        public void layoutContainer(Container container) {
            // Список компонентов
            Component list[] = container.getComponents();
            int currentY = 5;
            for (int i = 0; i < list.length; i++) {
                // Определение предпочтительного размера компонента
                Dimension pref = list[i].getPreferredSize();
                // Размещение компонента на экране
                list[i].setBounds(5, currentY, pref.width, pref.height);
                // Учитываем промежуток в 5 пикселов
                currentY += 5;
                // Смещаем вертикальную позицию компонента
                currentY += pref.height;
            }
        }

        // Метод вычисления оптимального размера контейнера
        private Dimension calculateBestSize(Container c) {
            // Вычисление длины контейнера
            Component[] list = c.getComponents();
            int maxWidth = 0;
            for (int i = 0; i < list.length; i++) {
                int width = list[i].getWidth();
                // Поиск компонента с максимальной длиной
                if (width > maxWidth)
                    maxWidth = width;
            }
            // Размер контейнера в длину с учетом левого отступа
            size.width = maxWidth + 5;
            // Вычисление высоты контейнера
            int height = 0;
            for (int i = 0; i < list.length; i++) {
                height += 5;
                height += list[i].getHeight();
            }
            size.height = height;
            return size;
        }
    }
}