import java.util.concurrent.*;
import java.util.*;
public class ExecutorCallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = List.of(
            () -> {
                Thread.sleep(1000);
                return "Task 1 completed";
            },
            () -> {
                Thread.sleep(500);
                return "Task 2 completed";
            },
            () -> {
                Thread.sleep(700);
                return "Task 3 completed";
            }
        );

        List<Future<String>> futures = new ArrayList<>();
        for (Callable<String> task : tasks) {
            futures.add(executor.submit(task));
        }

        for (Future<String> future : futures) {
            String result = future.get();
            System.out.println(result);
        }
        executor.shutdown();
    }
}
