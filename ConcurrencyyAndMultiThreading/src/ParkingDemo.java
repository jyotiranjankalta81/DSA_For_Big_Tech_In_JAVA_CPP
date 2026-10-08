//public class CarSlotBooking {
//}


import java.util.concurrent.locks.ReentrantLock;

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
