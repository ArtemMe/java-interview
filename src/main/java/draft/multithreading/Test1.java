package draft.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Test1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> tasks = Arrays.asList(
                ()-> {TimeUnit.SECONDS.sleep(15); return "5";},
                ()-> {TimeUnit.SECONDS.sleep(10); return "2";},
                ()-> {TimeUnit.SECONDS.sleep(5); return "1";}
        );

        List<Future<String>> futures = executor.invokeAll(tasks);

        for(Future<String> f : futures){
            String s = f.get();
            System.out.println(s);
        }
    }
}
