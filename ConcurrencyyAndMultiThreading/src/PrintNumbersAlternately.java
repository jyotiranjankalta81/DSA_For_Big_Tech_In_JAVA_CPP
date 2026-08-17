class NumberPrinter{
    private int number = 1;
    private  final  int limit;


    NumberPrinter(int limit) {
        this.limit = limit;
    }


    public synchronized void printOdd() throws InterruptedException{
        while (number<=limit){
            while (number%2==0){
                wait();
            }
            if (number<=limit){
                System.out.println(Thread.currentThread().getName() + " : " + number);
                number++;
            notifyAll();
            }
        }
    }
    public synchronized void prientEven() throws InterruptedException{
        while (number<=limit){
            while (number%2==1){
                wait();
            }
            if (number<=limit){
                System.out.println(Thread.currentThread().getName() + " : " + number);
                number++;
                notifyAll();
            }
        }
    }
}

public class PrintNumbersAlternately {


    public static void main (String[] args){

        NumberPrinter printer = new NumberPrinter(10);
        Thread oddThread = new Thread(()->{
            try {
                printer.printOdd();

            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        Thread eventhred = new Thread(()->{
            try {
                printer.prientEven();;
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();

            }
        });


        oddThread.start();
        eventhred.start();

    }
}
