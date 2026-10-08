package MultiThreadingVersion1CodeProblems;

public class Thread2WaitForThread1 {
    public static void main (String[] args) throws InterruptedException{
        Thread th1 = new Thread(()->{
            System.out.println("Thread 1 Started");
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
                System.out.println("Thread 1 ComPleted");
        },"Thread-1");

        Thread th2 = new Thread(()->{
            System.out.println("Thread 2 waiting for Thread1 Started");
            try{
                th1.join();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread 2 started its work");
            System.out.println("Thread 2 completed");
        },"Thread-1");

        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.out.println("Thread Completed Successfully");
    }
}
