public class DigitSum {


    public static int digitSum(int no){
        if(no<10){
            return no;
        }

        return no%10+ digitSum(no/10);
    }

    public static void main(String[] args){
        int n=67;
        System.out.println("The final Sum value is: " + digitSum(n));
    }
}
