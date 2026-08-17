import java.util.concurrent.Semaphore;

class SemaphoreRateLimit{
    private  final  Semaphore semaphore;



    SemaphoreRateLimit(int rateLimit){
        this.semaphore= new Semaphore(rateLimit);
    }

    public void processRequest(Runnable task){
        try{
            semaphore.acquire();
            task.run();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            semaphore.release();
        }
    }
}


public class SemaphoreRateLimitingConcurrency {





    public static void main (String [] args ){
        SemaphoreRateLimit ratelimt = new SemaphoreRateLimit(3);

        Runnable task = ()->{
            try {
                System.out.println(" Thread Name " + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("Thread Name " + Thread.currentThread().getName());
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        };

        for (int i=0;i<10;i++){
            new Thread(()->ratelimt.processRequest(task)).start();
        }

    }
}
