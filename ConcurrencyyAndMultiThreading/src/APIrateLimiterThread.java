import java.util.*;




public class APIrateLimiterThread {

    private final int maxWindowSize;
    private  final long windowSizeMillis;

    private  int requestCount=0;
    private long windowStart;

    public  APIrateLimiterThread(int maxWindowSize,long windowSizeMillis){
        this.maxWindowSize= maxWindowSize;
        this.windowSizeMillis = windowSizeMillis;
        this.windowStart= System.currentTimeMillis();
    }

    public  synchronized  boolean allowRequest(){
        long now = System.currentTimeMillis();
        if(now-windowStart>=windowSizeMillis){
            windowStart=now;
            requestCount=0;
        }

        if(requestCount<maxWindowSize){
            requestCount++;
            return true;
        }

        return false;
    }



    public static void main(String [] args){


        APIrateLimiterThread limiter = new APIrateLimiterThread(5,10000);

        for (int i=0;i<7;i++){
            if (limiter.allowRequest()) {
                System.out.println("Request " + i + " Allowed");
            } else {
                System.out.println("Request " + i + " Rejected");
            }
        }
    }
}
//public static void Main(String [] args){
//
//
//    APIrateLimiterThread limiter = new APIrateLimiterThread(5,10000);
//
//    for (int i=0;i<7;i++){
//        if (limiter.allowRequest()) {
//            System.out.println("Request " + i + " Allowed");
//        } else {
//            System.out.println("Request " + i + " Rejected");
//        }
//    }
//}