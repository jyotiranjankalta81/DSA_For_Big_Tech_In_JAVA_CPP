

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class BlockingQueueThread {

    static BlockingQueue<Integer> queue =
            new ArrayBlockingQueue<>(5);
static class Producer implements Runnable {

    @Override
    public void run() {

        try {

            for(int i=1;i<=10;i++){

                queue.put(i);

                System.out.println("Produced : "+i);

                Thread.sleep(500);
            }

        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
    }
}


static class Consumer implements Runnable {

    @Override
    public void run() {

        try{

            while(true){

                int item = queue.take();

                System.out.println("Consumed : "+item);

                Thread.sleep(1000);
            }

        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
    }
}

    public static void main(String[] args) {

        Thread producer = new Thread(new Producer());

        Thread consumer = new Thread(new Consumer());

        producer.start();
        consumer.start();
    }
}