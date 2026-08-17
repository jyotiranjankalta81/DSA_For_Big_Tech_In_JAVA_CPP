public class factorial {

    public static int calculateFactorial(int value){

        if(value==1){
            return 1;
        }
       return value*calculateFactorial(value-1);
//        return result;
    }

    public static int fibanaciNo(int value){
        if (value == 0) {
            return 0;
        }

        if(value==1){
            return 1;
        }
        return fibanaciNo(value-2)+fibanaciNo(value-1);
//        return result;
    }
    public static void main (String[] args){
        int n = 6;
//        System.out.println("Factorial of  " + n+" is: " +calculateFactorial(n));

        System.out.println("Fibonaci of  " + n+" is: " +fibanaciNo(n));
    }
}
