//public class DeadLockInThread {
//
//    private static final Object lock1 = new Object();
//    private static final Object lock2 = new Object();
//
//    public static void main(String[] args) {
//
//        Thread t1 = new Thread(() -> {
//
//            synchronized (lock1) {
//
//                System.out.println("Thread-1 acquired Lock1");
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//
//                System.out.println("Thread-1 waiting for Lock2");
//
//                synchronized (lock2) {
//
//                    System.out.println("Thread-1 acquired Lock2");
//
//                }
//            }
//
//        });
//
//        Thread t2 = new Thread(() -> {
//
//            synchronized (lock2) {
//
//                System.out.println("Thread-2 acquired Lock2");
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//
//                System.out.println("Thread-2 waiting for Lock1");
//
//                synchronized (lock1) {
//
//                    System.out.println("Thread-2 acquired Lock1");
//
//                }
//            }
//
//        });
//
//        t1.start();
//        t2.start();
//    }
//}
//
//
////
////Solution 1 (Most Common)
////
////Always acquire locks in the same order.
//
//
//


public class DeadlockFixed {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        Runnable task = () -> {

            synchronized (lock1) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " acquired Lock1");

                synchronized (lock2) {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " acquired Lock2");
                }
            }
        };

        new Thread(task, "Thread-1").start();

        new Thread(task, "Thread-2").start();
    }
}
