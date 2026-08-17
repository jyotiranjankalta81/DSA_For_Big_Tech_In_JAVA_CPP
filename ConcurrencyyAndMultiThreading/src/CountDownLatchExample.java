import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {



    public static void main(String[] args)
        throws InterruptedException{

        int workerCount=3;
        CountDownLatch latch = new CountDownLatch(workerCount);
        for (int i=0;i<=workerCount;i++){
                int workerId=i;
            new Thread(()->{

                try {

                    System.out.println("worker " + workerId+ " Started");
                    Thread.sleep(500);
                    System.out.println(
                            "Worker "
                                    + workerId
                                    + " finished");

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }finally {
                    latch.countDown();
                }

           }).start();

            }


        System.out.println("Main thread is Waiting");
        latch.await();
        System.out.println("All workers completed");


    }
}
