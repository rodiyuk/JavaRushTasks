package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            new Thread(new Producer(queue)).start();
            while (!queue.isEmpty()) {
                System.out.println(queue.take());
                Thread.sleep(200);
            }

        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
