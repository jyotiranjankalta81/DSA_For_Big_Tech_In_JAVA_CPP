import java.util.concurrent.*;

public class ThreadPoolShutDown {
    public static void main (String[] args){
        ThreadPoolExecutor execute = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for(int i=0;i<6;i++){
            int taskId = i;
            execute.submit(()->{
                try{
                    System.out.println("Task " + taskId + " is Started by " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    System.out.println("Task "+ taskId + " is Completed ");

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();

                }
            });
        }
        execute.shutdown();

        try {
            if(!execute.awaitTermination(10,TimeUnit.SECONDS)){
                execute.shutdownNow();
                if(!execute.awaitTermination(5,TimeUnit.SECONDS)){
                    System.out.println("Executor didn't terminate");
                }
            }
        }catch (InterruptedException e){
            execute.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("System shutdown successfully");

    }


}
