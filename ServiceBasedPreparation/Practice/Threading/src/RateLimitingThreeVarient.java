import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


    class slidingWindowRateLimiter{
        private final int capacity;
        private final  long windowMaxMillions;

        slidingWindowRateLimiter(int capacity,long windowMaxMillions){
            this.capacity=capacity;
            this.windowMaxMillions=windowMaxMillions;
        }

        private final Map<String,Deque<Long>> request = new ConcurrentHashMap<>();


        public  boolean allowRequest(String id){
            long now = System.currentTimeMillis();
            Deque<Long> queue = request.computeIfAbsent(id,k->new ArrayDeque<>());

            synchronized (queue){
                while (!queue.isEmpty()&& now - queue.peekFirst()>=windowMaxMillions){
                    queue.pollFirst();
                }

                if(queue.size()>=capacity){
                    return false;
                }
                queue.offerLast(now);
                return true;
            }

        }


    }
    class fixedWindowRateLimitor{

        private final int maxRequest;
        private final long windowMillis;
        private final Map<String,RequestCounter> request = new ConcurrentHashMap<>();

        fixedWindowRateLimitor(int maxRequest,long windowMillis){
            this.maxRequest= maxRequest;
            this.windowMillis= windowMillis;
        }

        public boolean allowRequest(String id){
            Long now = System.currentTimeMillis();
            RequestCounter counter = request.computeIfAbsent(id,k->new RequestCounter(now));
            synchronized (counter){


                if(now-counter.windowStart>=windowMillis){
                    counter.windowStart=now;
                    counter.count=0;
                }
                if(counter.count>=maxRequest) return false;
                counter.count++;
                return true;
            }
        }

        private static class RequestCounter{
            long windowStart;
            int count;

            RequestCounter(long windowStart){
                this.count=0;
                this.windowStart= windowStart;
            }
        }

    }






public class RateLimitingThreeVarient {

    public static void main(String[] args){
        slidingWindowRateLimiter limitor0 = new slidingWindowRateLimiter(5,10000);
        fixedWindowratelimiter limitor = new fixedWindowratelimiter(5,10000);

        ExecutorService executor =
                Executors.newFixedThreadPool(7);

        Runnable task= ()->{



                boolean allowed =
                        limitor.allowRequest("userX");

                System.out.println(
                        Thread.currentThread().getName()
                                + " -> "
                                + (allowed?"Allowed":"NotAllowed")
                );


        };

        for (int i=0;i<27;i++){

            executor.submit(task);
        }
        executor.shutdown();






    }
}
