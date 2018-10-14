package draft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new Task());
        executor.submit(new Task());
        executor.submit(new Task());

        Thread.sleep(1000);
        executor.shutdownNow();
        executor.awaitTermination(20, TimeUnit.MILLISECONDS);
    }
}

class Task implements Runnable{
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) // тут не подходит просто while(true) так как поток не прирывается
            System.out.println("hello from task thread ->"+Thread.currentThread().getId());
    }
}
