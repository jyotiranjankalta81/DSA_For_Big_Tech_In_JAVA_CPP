package MultiThreadingVersion1CodeProblems;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class Producer1 implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Producer1(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            try {

                queue.put(i);

                System.out.println(
                        Thread.currentThread().getName()
                                + " produced: "
                                + i
                );

                Thread.sleep(500);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

class Consumer1 implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Consumer1(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            try {

                int task = queue.take();

                System.out.println(
                        Thread.currentThread().getName()
                                + " consumed: "
                                + task
                );

                Thread.sleep(5000);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}


class BlockingQueueThread{
    public static void main(String[] args){


        BlockingQueue<Integer> queue =
                new ArrayBlockingQueue<>(10);

        // 3 producers
        for (int i = 1; i <= 3; i++) {

            new Thread(
                    new Producer1(queue),
                    "Producer-" + i
            ).start();
        }

        // 3 consumers
        for (int i = 1; i <= 3; i++) {

            new Thread(
                    new Consumer1(queue),
                    "Consumer-" + i
            ).start();
        }

        System.out.println("Processing completed");

    }
}