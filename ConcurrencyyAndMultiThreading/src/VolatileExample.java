public class VolatileExample {

    private static volatile   boolean ruuning=true;

    private static int counter=1;

    public static void main(String[] args) throws InterruptedException{


        Thread worker = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " Worker Started");

            while (ruuning){
                counter++;
                System.out.println( Thread.currentThread().getName() + " Worker running " + counter);
            }
            System.out.println("Worker Stopped");
        });

        worker.start();
        Thread.sleep(10);
        System.out.println("Main Thread Stopping Worker");
        ruuning=false;
        worker.join();
        System.out.println("Main thread Finished");

    }
}
