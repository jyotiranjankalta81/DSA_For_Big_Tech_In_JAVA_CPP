import java.util.LinkedList;
import java.util.Queue;

class SimpleThreadPools {

//    private final int noofThreads;

    private final Queue<Runnable> taskQueue = new LinkedList<>();

    public SimpleThreadPools(int noofThreads) {
        for (int i=0;i<noofThreads;i++){
            new Worker().start();
        }
    }

    public void submit(Runnable task){
        synchronized (taskQueue){
            taskQueue.add(task);
            taskQueue.notify();
        }

    }

    private class Worker extends Thread{
        @Override
        public void run(){
            while (true){
                Runnable task;
                synchronized (taskQueue){
                    while (taskQueue.isEmpty()){
                        try {
                            taskQueue.wait();
                        }catch (InterruptedException e){
                            return;
                        }
                    }
                    task= taskQueue.poll();

                }
                task.run();
            }
        }
    }
}


public class SimpleThreadPool {

    public static void main(String[] args) {

        SimpleThreadPools pool =
                new SimpleThreadPools(3);

        for (int i = 1; i <= 10; i++) {

            int taskId = i;

            pool.submit(() -> {

                System.out.println(
                        Thread.currentThread()
                                .getName()
                                + " executed Task "
                                + taskId);
            });
        }
    }
}