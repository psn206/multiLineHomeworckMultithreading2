import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int numberThreads = 4;
        List<Callable<Integer>> listCallable = new ArrayList();
        Callable<Integer> myCallable1 = new MyCallable(300);
        Callable<Integer> myCallable2 = new MyCallable(200);
        Callable<Integer> myCallable3 = new MyCallable(100);
        Callable<Integer> myCallable4 = new MyCallable(400);
        listCallable.add(myCallable1);
        listCallable.add(myCallable2);
        listCallable.add(myCallable3);
        listCallable.add(myCallable4);
         ExecutorService threadPool = Executors.newFixedThreadPool(numberThreads);
        List<Future<Integer>> taskResults = threadPool.invokeAll(listCallable);
            System.out.println("Потоки с количеством выводимых сообщений:");
        for (Future<Integer> taskResult : taskResults
        ) {
            System.out.println("Количество выводимых сообщений: " + taskResult.get());
        }
        int taskResult = threadPool.invokeAny(listCallable);
        threadPool.shutdown();
        System.out.println("Самый быстрый поток с " + taskResult + " выводимых сообщений");
        threadPool.shutdown();

    }
}

