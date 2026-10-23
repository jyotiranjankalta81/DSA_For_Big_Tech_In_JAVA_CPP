//public class CarSlotBooking {
//}


import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.*;

class ParkingSlot {
    private final String slotId;
    private final ReentrantLock lock = new ReentrantLock();

    // Access this field only while holding this slot's lock.
    private String bookedBy;

    ParkingSlot(String slotId) {
        this.slotId = slotId;
    }

    boolean book(String userId) {
        lock.lock();
        try {
            // Check and update happen under the SAME lock.
            if (bookedBy != null) {
                System.out.println(userId + ": " + slotId + " already booked");
                return false;
            }

            bookedBy = userId;
            System.out.println(userId + ": booked " + slotId);
            return true;
        } finally {
            lock.unlock(); // Released even if an exception occurs
        }
    }

    boolean cancel(String userId) {
        lock.lock();
        try {
            if (!userId.equals(bookedBy)) {
                return false; // Only the booking owner can cancel
            }

            bookedBy = null;
            return true;
        } finally {
            lock.unlock();
        }
    }
}


public class ParkingDemo {
    public static void main(String[] args) throws InterruptedException {
        // Both tasks must share the SAME slot object.
        ParkingSlot slot = new ParkingSlot("A1");

        ExecutorService pool = Executors.newFixedThreadPool(2);
        CountDownLatch start = new CountDownLatch(1);

        try {
            pool.execute(() -> attemptBooking(slot, "User-1", start));
            pool.execute(() -> attemptBooking(slot, "User-2", start));

            start.countDown(); // Allow both tasks to attempt booking
        } finally {
            pool.shutdown();
        }

        pool.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void attemptBooking(
            ParkingSlot slot, String userId, CountDownLatch start) {
        try {
            start.await();
            slot.book(userId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}