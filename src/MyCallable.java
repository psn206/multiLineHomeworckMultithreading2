import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    public int spentTime;
    public MyCallable(int spentTime){
        this.spentTime = spentTime;
    }

    @Override
    public Integer call() throws Exception {

        try {
                Thread.sleep(this.spentTime);


        } catch (InterruptedException err) {

          }
        return  this.spentTime;
    }
}
