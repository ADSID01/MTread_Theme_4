public class Spec implements Runnable {

    private static final int TIME_TALK = 1000;

    @Override
    public void run() {
        try {
            while (true) {
                String call = ATS.getAtsQueue().poll();
                if (call != null) {
                    System.out.println(Thread.currentThread().getName() + " принял " + call);
                    Thread.sleep(TIME_TALK);
                    System.out.println(Thread.currentThread().getName() + " ответил на " + call + ".\n");
//                    ATS.readyCalls.incrementAndGet();
                    ATS.getReadyCalls().incrementAndGet();
                } else if (ATS.getReadyCalls().get() >= ATS.COUNT_CALLS) {
                    ATS.getReadyCalls().incrementAndGet();
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
