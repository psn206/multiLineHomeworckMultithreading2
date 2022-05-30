import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    public int spentTime;
    public MyCallable(int spentTime){
        this.spentTime = spentTime;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < spentTime+1; i++) {
            System.out.println("Я поток " + Thread.currentThread().getName() +
                    ". Печатаю сообщение  " + i + " из " + spentTime);
        }
        return  this.spentTime;
    }
}