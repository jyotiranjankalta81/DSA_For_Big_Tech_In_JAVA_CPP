package ProblemsAll30;


import java.util.ArrayDeque;
import java.util.Queue;

class Buffer{

    private   int capacity =5;
    private Queue<Integer> queue = new ArrayDeque<>();

    public synchronized void produce (int value) throws  InterruptedException{


        while (queue.size()==capacity){
            wait();
        }
        queue.offer(value);
        System.out.println("queue Consumed " + value);
        notifyAll();

    }
    public  synchronized void consume() throws InterruptedException{

        while (queue.isEmpty()){
            wait();
        }
        int value = queue.remove();
        System.out.println("Consumed " + value);

    }
}

class Producer implements Runnable{
    private final Buffer buffer;
    Producer(Buffer buffer){
        this.buffer = buffer;
    }
    public void run(){
        for (int i=0; i<5;i++){
            try {
                buffer.produce(i);
                System.out.println("Produce a new Task " + Thread.currentThread().getName());

            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements  Runnable{
    private final Buffer buffer;
    Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        for (int i=0; i<5;i++){
            try {
                 buffer.consume();
                 System.out.println("Consume one Task " + Thread.currentThread().getName());

            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
public class ProducerAndConsumerUsingCustomNotify {


    public static void main (String[] args) {


        Buffer buffer = new Buffer();

        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));


        producer.start();
        consumer.start();

    }

}
