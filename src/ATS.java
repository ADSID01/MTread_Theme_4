import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ATS implements Runnable {

    public static final int PAUSE = 500;
    public static final int COUNT_CALLS = 20;

    public static LinkedBlockingQueue<String> atsQueue = new LinkedBlockingQueue<>();
    public static AtomicInteger readyCalls = new AtomicInteger(0);

    @Override
    public void run(){
        try {
            for (int i = 1; i <= COUNT_CALLS; i++) {
                System.out.println("Звонок_" + i + "\n");
                atsQueue.offer("Звонок_" + i);
                Thread.sleep(PAUSE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
