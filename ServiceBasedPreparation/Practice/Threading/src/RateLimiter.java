import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// rate limitor with sliding window....
class rateLimiterSlidingWindow{
    private final int maxRequest;
    private final long windowMillis;

    public rateLimiterSlidingWindow(int maxRequest,int windowMillis){
        this.maxRequest=maxRequest;
        this.windowMillis = windowMillis;
    }
    private final Map<String,Deque<Long> > request = new ConcurrentHashMap<>();



    public  boolean allowRequest(String userId){

        long now = System.currentTimeMillis();

        Deque<Long> queue = request.computeIfAbsent(userId,id->new ArrayDeque<>());
        synchronized (queue){
        while (!queue.isEmpty() && now-queue.peekFirst()>=windowMillis){
            queue.pollFirst();
        }
        if(queue.size()>=maxRequest){
            return false;
        }
        queue.offerLast(now);
        return true;

        }

    }


}


// rate limitor fixed window
class fixedWindowratelimiter{
    private final int capacity;
    private final long windowmills;
    private final Map<String ,userWindow> request = new ConcurrentHashMap<>();

    fixedWindowratelimiter(int capacity,long windowmills){
        this.capacity= capacity;
        this.windowmills= windowmills;
    }

    public boolean allowRequest(String userId){
        long now = System.currentTimeMillis();
        userWindow counter = request.computeIfAbsent(userId,id->new userWindow(now));

        synchronized (counter){
            while (now-counter.windowStart>=windowmills){
                counter.windowStart=now;
                counter.capacity=0;
            }
            if(counter.capacity>=capacity){
                return false;
            }
            counter.capacity++;
            return true;
        }


    }



    public class userWindow{

        long windowStart;
        int capacity;


        userWindow(long now){
            this.windowStart=now;
        }

    }
}

// rate limitor bucket size
class bucketratelimiter{
    private final int maxRequest;
    private final long intervalMillis;
    private static Map<String,Bucket> request = new ConcurrentHashMap<>();

   public bucketratelimiter(int maxRequest,long intervalMillis){
        this.maxRequest= maxRequest;
        this.intervalMillis = intervalMillis;
    }

    public boolean allowRequest(String userId){
       Bucket bucket = request.computeIfAbsent(userId,id-> new Bucket(maxRequest));

       synchronized (bucket){
           refil(bucket);
           if(bucket.capacity<=0){
               return false;
           }
           bucket.capacity--;
           return true;
       }
    }

    private void refil(Bucket bucket){
       long now = System.currentTimeMillis();
       long elaspsedtime = now-bucket.lastRefilTime;
       long tokensNeedToAdd = elaspsedtime/intervalMillis;

       if(tokensNeedToAdd>0){
           bucket.capacity = (int) Math.min(maxRequest,bucket.capacity+tokensNeedToAdd);
           bucket.lastRefilTime+=tokensNeedToAdd*intervalMillis;
       }




    }

    public static class Bucket{
        int capacity;
        long lastRefilTime;
       public Bucket(int capacity){
            this.capacity = capacity;
            this.lastRefilTime= System.currentTimeMillis();

        }
    }
}
public class RateLimiter {

    public static void main (String[] args){


        rateLimiterSlidingWindow request = new rateLimiterSlidingWindow(5,10000);
        fixedWindowratelimiter request1 = new fixedWindowratelimiter(5,1000);

        bucketratelimiter request3 = new bucketratelimiter(3,10000);
        ExecutorService executer = Executors.newFixedThreadPool(7);

        Runnable task= ()->{
            String user = "user1";

            boolean allowed =
//                    request.allowRequest(user);

//                    request1.allowRequest(user);
                    request3.allowRequest(user);
            System.out.println(
                    Thread.currentThread().getName()+user
                            + " -> "
                            + (allowed?"Allowed":"NotAllowed")
            );

        };
        Runnable task1= ()->{
            String user = "user2";

            boolean allowed =
//                    request.allowRequest(user);

//                    request1.allowRequest(user);
                    request3.allowRequest(user);
            System.out.println(
                    Thread.currentThread().getName()+user
                            + " -> "
                            + (allowed?"Allowed":"NotAllowed")
            );

        };
        for(int i=0;i<6;i++){
            executer.submit(task);
        }
        for(int i=0;i<6;i++){
            executer.submit(task1);
        }
        executer.shutdown();

    }
}
