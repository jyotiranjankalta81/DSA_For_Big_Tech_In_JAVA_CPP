package ProblemsAll30;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



class Producer2 implements Runnable{
        private final BlockingQueue<Integer> queue;

        Producer2(BlockingQueue queue){
            this.queue = queue;
        }
        @Override
        public  void run(){
            for (int i=0;i<4;i++){
                try {
                    queue.offer(i);
                    Thread.sleep(5000);
                    System.out.println("Task Produces By " + Thread.currentThread().getName());

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    class  Consumer2 implements  Runnable{
        private final BlockingQueue<Integer> queue;
        Consumer2(BlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run(){
            for (int i=0;i<4;i++){
                try {
                    int task = queue.take();

                    System.out.println("Task Consume by " + Thread.currentThread().getName());
                    Thread.sleep(7000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }

            }
        }
    }

public class ProducerConsumerByBlockingQuue {


    public static void main (String[] args){
        BlockingQueue queue = new LinkedBlockingQueue(5);

        // 2 producers

        System.out.println("curr status of queue level1 ------->" + queue);

        for (int i=0;i<2;i++){
            new Thread(new Producer2(queue),"Producer-" + i).start();
        }

        System.out.println("curr status of queue level2 ------->" + queue);
        //2 consumers
        for (int i=0;i<2;i++){
            new Thread(new Consumer2(queue),"Consumer-" + i).start();
        }

        System.out.println("curr status of queue level3 ------->" + queue);


    }
}
