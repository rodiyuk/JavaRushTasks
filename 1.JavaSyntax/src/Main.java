import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        char[] number = "+38(050)123-45-67".toCharArray();
        System.out.println(Arrays.toString(number));
        String phone = "";
        for (char c : number) {
            if (Character.isDigit(c)) {
                System.out.println(c);
                phone+=c;
            }
        }
        System.out.println("callto://+" + phone);
    }
}