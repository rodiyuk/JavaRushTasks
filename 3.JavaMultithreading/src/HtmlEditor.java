import javax.swing.*;
import java.awt.*;

public class HtmlEditor {

    public static JFrame frame = new JFrame("Coogle.html");
    public static JMenuBar menuBar = new JMenuBar();
    public static JTabbedPane tabbedPane = new JTabbedPane();

    public static void initView(){
        frame.setSize(600,400);
        frame.setJMenuBar(menuBar);
        menuBar.add(new JMenu("Файл"));
        menuBar.add(new JMenu("Редактировать"));
        menuBar.add(new JMenu("Стиль"));
        JMenu menu = new JMenu("Вырвнивание");
        menu.setSelected(true);
        menuBar.add(menu);
        menuBar.add(new JMenu("Цвет"));
        menuBar.add(new JMenu("Шрифт"));
        menuBar.add(new JMenu("Помощь"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(tabbedPane);
        tabbedPane.addTab("HTML", new JScrollPane(new JTextArea()));
        tabbedPane.addTab("Текст", new JTextArea(10,20));
        tabbedPane.setVisible(true);
        tabbedPane.setAutoscrolls(true);
        frame.getContentPane().add(BorderLayout.WEST, panel);
        frame.pack();
    }

    public static void main(String[] args) {
        initView();
    }
}
