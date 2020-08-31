import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Path path1 = Path.of("c://test1//test01//test001//test.txt");
        Path path2 = Path.of("c://test2");
        System.out.println(path2.resolve(path2.relativize(path1)));
    }
}