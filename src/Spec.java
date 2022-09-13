public class Spec implements Runnable {

    private static final int TIME_TALK = 1000;

    @Override
    public void run() {
        try {
            while (true) {
                String call = ATS.atsQueue.poll();
                if (call != null) {
                    System.out.println(Thread.currentThread().getName() + " принял " + call);
                    Thread.sleep(TIME_TALK);
                    System.out.println(Thread.currentThread().getName() + " ответил на " + call + ".\n");
                    ATS.readyCalls.incrementAndGet();
                } else if (ATS.readyCalls.get() >= ATS.COUNT_CALLS) {
                    ATS.readyCalls.incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + " Готово.");
                    break;
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
