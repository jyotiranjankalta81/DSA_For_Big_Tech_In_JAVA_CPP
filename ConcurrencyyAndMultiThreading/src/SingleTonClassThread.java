public class SingleTonClassThread {


    private  static volatile SingleTonClassThread instance;

    private SingleTonClassThread(){
        System.out.println("Singleton Object Created");
    }

    public static SingleTonClassThread getInstance(){
        if(instance==null){
            synchronized (SingleTonClassThread.class){
                if (instance==null) {
                    instance = new SingleTonClassThread();
                }
            }
        }
    return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton");
    }

    public static void main(String[] args) {

        SingleTonClassThread s1 = SingleTonClassThread.getInstance();

        SingleTonClassThread s2 = SingleTonClassThread.getInstance();

        SingleTonClassThread s3 = SingleTonClassThread.getInstance();

        s1.showMessage();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
    }
}
