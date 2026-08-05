import  java.util.concurrent.*;



/*
Typical production examples:

Cache refresh
Cleanup jobs
Retry failed messages
OTP expiration
Session cleanup
Health checks
Metrics collection
Scheduled report generation


 */
public class ScheduledExecutorThread {


    public static void main(String [] args){


        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> {

            System.out.println("OTP Sent");

        },5,TimeUnit.SECONDS);


    }
}
