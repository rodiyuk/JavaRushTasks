import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] ints = new int[5][5];
        //Рисуем все кусочки змеи
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (i == 0 || i == ints.length - 1)
                    System.out.print(".");
            }
            System.out.println();
        }
        //Рисуем мышь
        //Выводим все это на экран

    }

    public static void main(String[] args) throws IOException {
        print();
    }
}