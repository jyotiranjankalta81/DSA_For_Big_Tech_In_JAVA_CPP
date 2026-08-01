import java.util.LinkedList;
import java.util.Queue;

class Buffer {

    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 5;

    // Producer method
    public synchronized void produce(int value) throws InterruptedException {

        while (queue.size() == capacity) {
            wait(); // Wait if buffer is full
        }

        queue.add(value);
        System.out.println("Produced : " + value);

        notifyAll(); // Wake waiting consumers
    }

    // Consumer method
    public synchronized int consume() throws InterruptedException {

        while (queue.isEmpty()) {
            wait(); // Wait if buffer is empty
        }

        int value = queue.remove();
        System.out.println("Consumed : " + value);

        notifyAll(); // Wake waiting producers

        return value;
    }
}

class Producer implements Runnable {

    private Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            try {
                buffer.produce(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {

    private Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            try {
                buffer.consume();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerAndConsumer {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));

        producer.start();
        consumer.start();
    }
}


