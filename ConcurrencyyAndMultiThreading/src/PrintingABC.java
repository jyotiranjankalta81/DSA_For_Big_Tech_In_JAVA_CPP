package MultiThreadingVersion1CodeProblems;

public class PrintingABC {

    private final int limit;
    private  int turn;

    public PrintingABC(int limit){
        this.limit = limit;
    }

    public synchronized void printA(){
        while (turn<=limit*3){
            while (turn%3==1 || turn%3==2){
                try {
                    wait();

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            if(turn<=limit*3 && turn%3==0){
                    System.out.println(Thread.currentThread().getName()+ " -> " + "A");
                    turn++;
                    notifyAll();
            }
        }
    }
    public synchronized void printB(){
        while (turn<=limit*3){
            while (turn%3==0 || turn%3==2){
                try {
                    wait();

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            if(turn<=limit*3 && turn%3==1){
                System.out.println(Thread.currentThread().getName()+ " -> " + "B");
                turn++;
                notifyAll();
            }
        }
    }
    public synchronized void printC(){
        while (turn<=limit*3){
            while (turn%3==1 || turn%3==0){
                try {
                    wait();

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            if(turn<=limit*3 && turn%3==2){
                System.out.println(Thread.currentThread().getName()+ " -> " + "C");
                turn++;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        PrintingABC print = new PrintingABC(1);

        Thread th1 = new Thread(print::printA,"Th-1");
        Thread th2 = new Thread(print::printB,"Th-2");
        Thread th3 = new Thread(print::printC,"Th-3");

        th1.start();
        th2.start();
        th3.start();
        th1.join();
        th2.join();
        th3.join();
        System.out.println("Printed All Successfully");
    }
}
