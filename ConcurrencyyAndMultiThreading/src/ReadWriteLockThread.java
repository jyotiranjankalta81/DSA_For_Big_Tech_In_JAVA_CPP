import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Cache {

    private final Map<Integer, String> map = new HashMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public String get(int id) {

        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()
                    + " is READING key : " + id);

            Thread.sleep(2000); // Simulate reading

            return map.get(id);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            System.out.println(Thread.currentThread().getName()
                    + " finished READING");
            lock.readLock().unlock();
        }
    }

    public void put(int id, String value) {

        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()
                    + " is WRITING key : " + id);

            Thread.sleep(3000); // Simulate writing

            map.put(id, value);

            System.out.println(Thread.currentThread().getName()
                    + " inserted : " + value);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName()
                    + " finished WRITING");
            lock.writeLock().unlock();
        }
    }
}

public class ReadWriteLockThread {

    public static void main(String[] args) {

        Cache cache = new Cache();

        // Initial Data
        cache.put(1, "Laptop");
        cache.put(2, "Mobile");

        Thread reader1 = new Thread(() -> {
            System.out.println("Reader1 Result : " + cache.get(1));
        }, "Reader-1");

        Thread reader2 = new Thread(() -> {
            System.out.println("Reader2 Result : " + cache.get(2));
        }, "Reader-2");

        Thread reader3 = new Thread(() -> {
            System.out.println("Reader3 Result : " + cache.get(1));
        }, "Reader-3");

        Thread writer = new Thread(() -> {
            cache.put(3, "Tablet");
        }, "Writer");

        reader1.start();
        reader2.start();
        reader3.start();

        // Start writer after readers
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        writer.start();
    }
}

