package MultiThreadingVersion1CodeProblems;


import java.util.LinkedList;
import java.util.Queue;
import  java.util.*;

class Buffer{

    private final int capacity;
    private Queue<Integer> queue = new LinkedList<>();

   public Buffer(int capacity){
       this.capacity = capacity;
   }

   public synchronized void produce(int value) throws InterruptedException{
       while (capacity==queue.size()){
           wait();
       }
       queue.offer(value);
       System.out.println("Produced " + value + " Burrer " + queue);
       notifyAll();
   }

   public synchronized  int consume() throws InterruptedException{
       while (queue.isEmpty()){
           wait();
       }
       int value = queue.poll();
       System.out.println("Consume " + value + " Buffer " + queue);
       notifyAll();
       return value;
   }




}

class Producer implements  Runnable {
    private final Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {


            try {
                buffer.produce(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}

class  Consumer implements Runnable{
    private final Buffer buffer;

    Consumer(Buffer buffer){
    this.buffer = buffer;
    }

    public void run(){
        for (int i=0;i<10;i++){
            try {
                buffer.consume();
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Producer_consumer {

        public  static void main (String[] args) {
            Buffer buffer = new Buffer(10);

            for (int i = 1; i <= 5; i++) {

                new Thread(
                        new Producer(buffer),
                        "Producer-" + i
                ).start();
            }
            for (int i = 1; i <= 3; i++) {

                new Thread(
                        new Consumer(buffer),
                        "Consumer-" + i
                ).start();
            }
        }

}
