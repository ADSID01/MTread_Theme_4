import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ATS implements Runnable {

    public static final int PAUSE = 500;
    public static final int COUNT_CALLS = 20;

    private static LinkedBlockingQueue<String> atsQueue = new LinkedBlockingQueue<>();
    private static AtomicInteger readyCalls = new AtomicInteger(0);

    public static LinkedBlockingQueue<String> getAtsQueue() {
        return atsQueue;
    }

    public static AtomicInteger getReadyCalls() {
        return readyCalls;
    }

    @Override
    public void run() {
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
