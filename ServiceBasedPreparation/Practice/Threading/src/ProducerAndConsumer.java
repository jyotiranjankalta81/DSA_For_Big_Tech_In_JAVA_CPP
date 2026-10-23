import java.util.ArrayDeque;
import java.util.Queue;
import  java.util.*;




class Buffer{
    public  int capacity =5;
    Queue<Integer> queue = new ArrayDeque<>();

    public synchronized void producer(int value) throws InterruptedException{
        while (queue.size()==capacity){
            wait();
        }
        queue.add(value);
        notifyAll();
        System.out.println("Value " + value + " One task Produced " + Thread.currentThread().getName());
    }
    public synchronized  void consumer() throws InterruptedException{
        while (queue.isEmpty()){
            wait();
        }
        int value = queue.remove();
        notifyAll();
        System.out.println("value " + value + " One task Consumed "+ Thread.currentThread().getName() );
    }
}
class Producer implements  Runnable{

   private final Buffer buffer;

   Producer(Buffer buffer){
       this.buffer = buffer;
   }

   @Override
    public void run(){
       for(int i=0;i<5;i++){
           try {

               buffer.producer(i);
               Thread.sleep(1000);

           }catch (InterruptedException e){
               Thread.currentThread().interrupt();
           }
       }
   }
}

class Consumer implements Runnable{
    private final Buffer buffer;
    Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for(int i=0;i<5;i++){
            try {
                buffer.consumer();
                Thread.sleep(10000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerAndConsumer{


     public static void main (String[] args ) {


         Buffer buff = new Buffer();

         int producerCount = 3;
         int consumerCount = 3;

         for (int i = 1; i <= producerCount; i++) {
             Thread producer = new Thread(
                     new Producer(buff),
                     "Producer-" + i
             );

             producer.start();
         }

         for (int i = 1; i <= consumerCount; i++) {
             Thread consumer = new Thread(
                     new Consumer(buff),
                     "Consumer-" + i
             );

             consumer.start();
         }



     }




}
