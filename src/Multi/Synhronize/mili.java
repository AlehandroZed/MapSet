package Multi.Synhronize;

public class mili {
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            try {
                long before = System.currentTimeMillis();
                Thread.sleep(3);
                long after = System.currentTimeMillis();
                System.out.println("Time: " + (after - before));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
