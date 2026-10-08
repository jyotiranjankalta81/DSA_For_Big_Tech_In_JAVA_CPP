package MultiThreadingVersion1CodeProblems;

public class CustomCyclicBarrier {

    private final int parties;
    public int remaning;
    private int generation;

    public CustomCyclicBarrier(int parties,int generation){
        this.parties= parties;
        this.generation= generation;
    }

    public  synchronized void  await() throws InterruptedException{

        if(remaning==0){
            generation++;
            remaning=parties;
            System.out.println(Thread.currentThread().getName()+" in common meeting Point");
            notifyAll();

        }else {
            System.out.println(Thread.currentThread().getName()+ "waiting for remaining thread");
            wait();
        }

    }


    public static void main (String[] args) throws  InterruptedException{
        CustomCyclicBarrier barrier = new CustomCyclicBarrier(3,5);

        Runnable workerTask = (()->{
           try {
               System.out.println(Thread.currentThread().getName() + " Thread Started Operation");
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
           }
        });

        Thread th1 = new Thread(workerTask,"Th1");
        Thread th2 = new Thread(workerTask,"Th1");
        Thread th3 = new Thread(workerTask,"Th1");

        System.out.println("all  thread staarted Execution");

        th1.start();
        th2.start();
        th3.start();
        System.out.println("all thread are processing waiting for the final one");
               barrier.await();

        System.out.println("all Thread Executed");


    }


}
