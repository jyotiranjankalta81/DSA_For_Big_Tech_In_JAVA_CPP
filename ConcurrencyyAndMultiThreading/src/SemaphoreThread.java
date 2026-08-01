import  java.util.*;
import java.util.concurrent.Semaphore;

public class SemaphoreThread {

    static Semaphore semaphore = new Semaphore(2);
    public  static  void main (String [] args){


        Runnable task = ()->{

            try {
                System.out.println(
                        Thread.currentThread().getName()
                                + " waiting...");

                semaphore.acquire();

                System.out.println(
                        Thread.currentThread().getName()
                                + " acquired permit");

                Thread.sleep(3000);

                System.out.println(
                        Thread.currentThread().getName()
                                + " completed");

                semaphore.release();

            } catch (Exception e) {

                Thread.currentThread().interrupt();
            }
        };
        for (int i = 1; i <= 5; i++) {

            new Thread(task, "Thread-" + i).start();

        }


    }
}
