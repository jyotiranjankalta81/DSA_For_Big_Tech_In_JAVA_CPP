import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class BankAccount {

    private int balance = 1000;

    private final ReentrantLock lock =
            new ReentrantLock();

    public void withdraw(int amount) {

        lock.lock();

        try {

            System.out.println(
                    Thread.currentThread().getName()
                            + " acquired lock");

            if (balance >= amount) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " withdrawing " + amount);

                balance -= amount;

                System.out.println(
                        "Remaining balance: " + balance);

            } else {

                System.out.println(
                        Thread.currentThread().getName()
                                + " insufficient balance");
            }

        } finally {

            lock.unlock();

            System.out.println(
                    Thread.currentThread().getName()
                            + " released lock");
        }
    }
}



class Cache{
    private final ReadWriteLock rwd = new ReentrantReadWriteLock();

    private final Lock readlock = rwd.readLock();
    private final Lock writeLock = rwd.writeLock();

    private  final Map<Integer,Integer> prices = new HashMap<>();


//    multiple thread can read simultaneusly

    public Integer getPrice(int productId){
        readlock.lock();
        int price=0;

        try {

            System.out.println("lock ");
           price =   prices.get(productId);
        }finally {
            readlock.unlock();
        }
        return price;
    }
    // Only one writer; no concurrent readers
    public void updatePrice(
            int productId,
            int price) {

        writeLock.lock();

        try {

            System.out.println(
                    Thread.currentThread().getName()
                            + " updating product " + productId);

            prices.put(productId, price);

        } finally {

            writeLock.unlock();
        }
    }

}
public class RentrantLock {

    public static void main(String[] args)
            throws InterruptedException {

        BankAccount account =
                new BankAccount();

        Thread t1 = new Thread(
                () -> account.withdraw(700),
                "Thread-1");

        Thread t2 = new Thread(
                () -> account.withdraw(700),
                "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Both threads completed");



        Cache cache =
                        new Cache();

        cache.updatePrice(101, 500);

        Runnable reader = () -> {

                    Integer price = cache.getPrice(101);

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " Price: " + price);
                };

        Runnable writer = () -> {

                    cache.updatePrice(101, 700);
                };

        Thread t11 = new Thread(reader, "Reader-1");
        Thread t21 = new Thread(reader, "Reader-2");
        Thread t31 = new Thread(reader, "Reader-3");

        Thread t41 = new Thread(writer, "Writer-1");

                t11.start();
                t21.start();
                t31.start();
                t41.start();

                t11.join();
                t21.join();
                t31.join();
                t41.join();

    }
}