package MultiThreadingVersion1CodeProblems;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

 class FixedWindowRateLimiter {

    private final long windowSizeMillis;

    private final int maxRequests;

    private final Map<String, RequestCounter> users =
            new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(
            int maxRequests,
            long windowSizeMillis) {

        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
    }

    public boolean allowRequest(String userId) {

        long now = System.currentTimeMillis();

        RequestCounter counter =
                users.computeIfAbsent(
                        userId,
                        k -> new RequestCounter(now)
                );

        synchronized (counter) {

            if (now - counter.windowStart
                    >= windowSizeMillis) {

                counter.windowStart = now;

                counter.count = 0;
            }

            if (counter.count >= maxRequests) {

                return false;
            }

            counter.count++;

            return true;
        }
    }

    private static class RequestCounter {

        long windowStart;

        int count;

        RequestCounter(long windowStart) {

            this.windowStart = windowStart;
        }
    }
}

 class SlidingWindowRateLimiter {

    private final int maxRequests;

    private final long windowSizeMillis;

    private final Map<String, Deque<Long>> requests =
            new ConcurrentHashMap<>();

    public SlidingWindowRateLimiter(
            int maxRequests,
            long windowSizeMillis) {

        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
    }

    public boolean allowRequest(String userId) {

        long now = System.currentTimeMillis();

        Deque<Long> queue =
                requests.computeIfAbsent(
                        userId,
                        k -> new ArrayDeque<>()
                );

        synchronized (queue) {

            while (!queue.isEmpty()
                    && now - queue.peekFirst()
                    >= windowSizeMillis) {

                queue.pollFirst();
            }

            if (queue.size() >= maxRequests) {

                return false;
            }

            queue.offerLast(now);

            return true;
        }
    }
}
public class RateLimitWithThreeVariety {





        public static void main(String[] args) {

            SlidingWindowRateLimiter limiter =
                    new SlidingWindowRateLimiter(
                            5,
                            10_000
                    );

            ExecutorService executor =
                    Executors.newFixedThreadPool(7);

            Runnable task = () -> {

                String user = "user1";

                boolean allowed =
                        limiter.allowRequest(user);

                System.out.println(
                        Thread.currentThread().getName()
                                + " -> "
                                + (allowed?"Allowed":"NotAllowed")
                );
            };

            for (int i = 0; i < 20; i++) {

                executor.submit(task);
            }

            executor.shutdown();
        }

}
