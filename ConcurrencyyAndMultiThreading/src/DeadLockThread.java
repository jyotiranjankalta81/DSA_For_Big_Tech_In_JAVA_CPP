public class DeadLockThread {


        public static final Object lock1 = new Object();
        public static final Object lock2 = new Object();
    public static void main (String[] args){
        Thread thread1 = new Thread(()->{
            synchronized (lock1){

                System.out.println("Thread-1 acquired lock 1");
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread-1 looking for lock-1");
            synchronized (lock2){
                System.out.println("Thread-1 acquired lock-2");
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (lock2){

                System.out.println("Thread-2 acquired lock 2");
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread-2 looking for lock-1");
            synchronized (lock1){
                System.out.println("Thread-2 acquired lock-1");
            }
        });

        thread1.start();
        thread2.start();

    }
}
