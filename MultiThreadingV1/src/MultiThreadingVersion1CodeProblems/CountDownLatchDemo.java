package MultiThreadingVersion1CodeProblems;

import java.util.concurrent.CountDownLatch;

class CouuntDownLatchV1{
    private int count;
    public CouuntDownLatchV1(int count){
        this.count=count;
    }
    public synchronized void await() throws InterruptedException{
        while (count>0){
            wait();
        }
    }
    public synchronized void countDown(){
        if(count==0){
            return;
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"  reduced the count to " + count);
        if (count==0){

        notifyAll();
        }
    }

}
public class CountDownLatchDemo {

    public static void main(String[] args) throws  InterruptedException{
        CouuntDownLatchV1 latch = new CouuntDownLatchV1(3);
        CountDownLatch latchV1 = new CountDownLatch(3);
        Runnable workerTask = ()->{
            try {
                System.out.println(Thread.currentThread().getName() + " Start Working");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " Completed It's Work");

            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }finally {
                latchV1.countDown();
            }
        };


        Thread worker1 = new Thread(workerTask,"Thread1");
        Thread worker2 = new Thread(workerTask,"Thread2");
        Thread worker3 = new Thread(workerTask,"Thread3");

        worker1.start();
        worker2.start();
        worker3.start();

        System.out.println("Main Worker is Waiting for the all the workers");
        latchV1.await();
        System.out.println("All Workers Completed Main Continues");

    }

}
