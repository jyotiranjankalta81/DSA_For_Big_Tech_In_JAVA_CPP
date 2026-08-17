import java.util.concurrent.CyclicBarrier;


public class CyclicBarrierThread {


    public static void main(String[] args){
        CyclicBarrier  barrier = new CyclicBarrier(3);


        Runnable worker = ()->{
            try {
                String name = Thread.currentThread().getName();

                System.out.println("Name " + name+ " Started");
                Thread.sleep(5000);
                System.out.println("Reach the Barrier " + name);
                barrier.await();
                System.out.println("Continued " + name);

            }catch (Exception e){
                e.getStackTrace();
            }

        };
            new Thread(worker,"Worker-1").start();
        new Thread(worker,"Worker-2").start();
        new Thread(worker,"Worker-3").start();
    }
}
