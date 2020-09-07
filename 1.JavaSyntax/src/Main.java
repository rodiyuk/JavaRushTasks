import java.io.IOException;
import java.nio.file.*;
import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // пустой список
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<String> strings = new ArrayList<>();
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println(min.orElse(-1)); // -1

// непустой список
        Collections.addAll(strings, "4","5","6","7","8","9");
        min = numbers.stream().min(Integer::compare);
        System.out.println(min.orElse(-1)); // 4
    }
}