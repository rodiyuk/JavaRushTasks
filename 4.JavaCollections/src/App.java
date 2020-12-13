import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static volatile int value = 0;
    public static AtomicInteger atomic = new AtomicInteger(0);

    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                value++;
                atomic.incrementAndGet();
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }
        Thread.sleep(300);
        System.out.println(value);
        System.out.println(atomic.get());
    }
}