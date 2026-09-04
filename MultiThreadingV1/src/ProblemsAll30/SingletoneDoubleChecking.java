package ProblemsAll30;

public class SingletoneDoubleChecking {


    private static volatile  SingletoneDoubleChecking instance;

    private SingletoneDoubleChecking(){
        System.out.println("object created");
    }

    public static SingletoneDoubleChecking getInstance() {
        if(instance ==null){
            synchronized (SingletoneDoubleChecking.class){
                if(instance == null){
                    instance = new SingletoneDoubleChecking();

                }
            }

        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton");
    }
    public static void main(String[] args){


        SingletoneDoubleChecking s1 = SingletoneDoubleChecking.getInstance();
        SingletoneDoubleChecking s2 = SingletoneDoubleChecking.getInstance();
        SingletoneDoubleChecking s3 = SingletoneDoubleChecking.getInstance();

        SingletoneDoubleChecking s4= SingletoneDoubleChecking.getInstance();
        SingletoneDoubleChecking s5 = SingletoneDoubleChecking.getInstance();
        SingletoneDoubleChecking s6 = SingletoneDoubleChecking.getInstance();

        s1.showMessage();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);


        System.out.println(s1 == s2);
        System.out.println(s2 == s3);





    }
}
