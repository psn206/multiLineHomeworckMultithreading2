import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final int numberThreads = 4;
        List<MyCallable> listCallable = new ArrayList();
        for (int i = 0; i < numberThreads; i++) {
            listCallable.add(new MyCallable(i + 2));
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(numberThreads);
        System.out.println("Включаем все потоки:");
        List<Future<Integer>> taskResults = threadPool.invokeAll(listCallable);
        for (Future<Integer> taskResult : taskResults) {
            System.out.println("Количество выводимых сообщений потоком " + "= " + taskResult.get());
        }
        int taskResult = threadPool.invokeAny(listCallable);
        try {
            Thread.sleep(2000); // усыпляем на 2 секунды поток main
        } catch (InterruptedException ignored) {
        }
        System.out.println("Самый быстрый поток  выводит " + taskResult + " сообщения ");
        threadPool.shutdown();
    }
}

