import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException {
        System.out.println(LocalDate.of(1971, 1, 1).toEpochDay());
    }
}