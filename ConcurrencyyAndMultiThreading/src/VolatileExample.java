package MultiThreadingVersion1CodeProblems;

public class VolatileExample {

    private static volatile boolean ruuning=true;

    public static void main(String[] args) throws InterruptedException{


        Thread worker = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " Worker Started");

            while (ruuning){
                System.out.println( Thread.currentThread().getName() + " Worker running ");
            }
            System.out.println("Worker Stopped");
        });

        worker.start();
        Thread.sleep(1);
        System.out.println("Main Thread Stopping Worker");
        ruuning=false;
        worker.join();
        System.out.println("Main thread Finished");

    }
}
