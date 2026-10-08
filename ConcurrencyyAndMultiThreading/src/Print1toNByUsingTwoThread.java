package MultiThreadingVersion1CodeProblems;

public class Print1toNByUsingTwoThread {

        private  int number=1;
        private final int limit;

    Print1toNByUsingTwoThread(int limit){
        this.limit = limit;
    }


    public synchronized void printOdd(){
        while (number<=limit){
            while (number%2==0){
                try {
                wait();

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            if (number<=limit){
                System.out.println(Thread.currentThread().getName()+ " -> " + number);
            number++;
            notifyAll();
            }
        }
    }

    public synchronized void printEven(){
        while (number<=limit){
            while (number%2==1){
                try {
                    wait();

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            if (number<=limit){
                System.out.println(Thread.currentThread().getName()+ " -> " + number);
                number++;
                notifyAll();
            }
        }
    }


    public static void main (String[] args) throws InterruptedException {
        Print1toNByUsingTwoThread print = new Print1toNByUsingTwoThread(20);
        Thread th1= new Thread(print::printOdd, "Thread-1");
        Thread th2= new Thread(print::printEven,"Thread-2");
        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.out.println("Printing Completed");
    }

}
