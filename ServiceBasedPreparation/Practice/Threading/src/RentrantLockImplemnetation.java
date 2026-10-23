import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Caching{
    private final ReadWriteLock rwd = new ReentrantReadWriteLock();

    private final Lock readLock = rwd.readLock();
    private final Lock writeLock = rwd.writeLock();

    private final Map<String,Integer> products = new HashMap<>();

    public int getPrice(String ProductId){
        readLock.lock();
        int price;

        try {
            System.out.println("read lock locked");
            price =  products.get(ProductId);
           System.out.println("Product Price is " + price);
        }finally {
            readLock.unlock();
        }
        return price;
    }


    public void updateProduct(String productId,int price){
        writeLock.lock();

        try {
            System.out.println("write Locking started");
            products.put(productId,price);
        }finally {
            writeLock.unlock();
        }
    }
}


public class RentrantLockImplemnetation {

    public static void main (String[] args) throws InterruptedException{

    Caching cache = new Caching();
    cache.updateProduct("101",20);

    Runnable readTask = ()->{

        try {

        Integer price = cache.getPrice("101");

        System.out.println(
                Thread.currentThread().getName()
                        + " Price: " + price);
        }catch (Exception e){


            // Preserve the interruption signal.
            Thread.currentThread().interrupt();

            System.out.println("Main thread interrupted while waiting.");
        }
    };
        Runnable writer = () -> {

            cache.updateProduct("101", 700);
        };

        Thread t11 = new Thread(readTask, "Reader-1");
        Thread t21 = new Thread(readTask, "Reader-2");
        Thread t31 = new Thread(readTask, "Reader-3");

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
