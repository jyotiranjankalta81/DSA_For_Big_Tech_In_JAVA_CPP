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


 class TokenBucketRateLimiter {

    private final int capacity;
    private final int refillRatePerSecond;

    private final Map<String, Bucket> userBuckets =
            new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int capacity,
                                  int refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
    }

    public boolean allowRequest(String userId) {

        Bucket bucket = userBuckets.computeIfAbsent(
                userId,
                id -> new Bucket(capacity)
        );

        synchronized (bucket) {

            refill(bucket);

            if (bucket.tokens <= 0) {
                return false;
            }

            bucket.tokens--;

            return true;
        }
    }

    private void refill(Bucket bucket) {

        long now = System.currentTimeMillis();

        long elapsedMillis =
                now - bucket.lastRefillTime;

        long tokensToAdd =
                (elapsedMillis * refillRatePerSecond) / 1000;

        if (tokensToAdd > 0) {

            bucket.tokens = (int) Math.min(
                    capacity,
                    bucket.tokens + tokensToAdd
            );

            // Preserve fractional elapsed time.
            long millisPerToken = 1000L / refillRatePerSecond;

            bucket.lastRefillTime +=
                    tokensToAdd * millisPerToken;
        }
    }

    private static class Bucket {

        int tokens;
        long lastRefillTime;

        Bucket(int capacity) {
            this.tokens = capacity;
            this.lastRefillTime =
                    System.currentTimeMillis();
        }
    }

}
public class RateLimitWithThreeVariety {

        public static void main(String[] args) {

            SlidingWindowRateLimiter limiter1 =
                    new SlidingWindowRateLimiter(
                            5,
                            10_000
                    );
            FixedWindowRateLimiter limiter2 = new FixedWindowRateLimiter(5,10000);
            TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5,10000);

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
