
import java.util.LinkedList;
import java.util.Queue;

 class CustomBlockingQueue {

    private final Queue<Integer> queue;
    private final int capacity;

    public CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(int item)
            throws InterruptedException {

        while (queue.size() == capacity) {
            wait();
        }

        queue.add(item);

        notifyAll();
    }

    public synchronized int take()
            throws InterruptedException {

        while (queue.isEmpty()) {
            wait();
        }

        int item = queue.remove();

        notifyAll();

        return item;
    }
}


class Producer1 implements  Runnable{
    private CustomBlockingQueue queue;

    Producer1(CustomBlockingQueue queue){
        this.queue= queue;
    }

    @Override
    public void run(){
        try{
            for (int i=0; i<10;i++){
                queue.put(i);
                System.out.println("Produced " + i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}

class  Consumer1 implements  Runnable{

    private CustomBlockingQueue queue;

    Consumer1(CustomBlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run(){
        try{
            while (true){
               int item =  queue.take();
                System.out.println("Consumer : " + item);
                Thread.sleep(500);
            }

        } catch (Exception e) {

            Thread.currentThread().interrupt();
        }
    }
}

public class CustomBlockingQueueThread {

    public  static void main(String [] args){


        CustomBlockingQueue queue =
                new CustomBlockingQueue(3);

        Thread producer =
                new Thread(new Producer1(queue));

        Thread consumer =
                new Thread(new Consumer1(queue));

        producer.start();

        consumer.start();
    }
}
