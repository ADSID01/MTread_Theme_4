public class Main {
    public static final int COUNT_SPEC = 5;

    public static void main(String[] args){

        Thread ats = new Thread(null, new ATS()::run);
        ats.start();

        for(int i = 1; i <= COUNT_SPEC; i++) {
            new Thread(null, new Spec()::run, "Спец_" + i).start();
        }
    }
}
