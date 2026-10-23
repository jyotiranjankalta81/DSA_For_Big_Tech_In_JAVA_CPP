class singletonThread{
    private static volatile  singletonThread instance;

    public static singletonThread getInstance(){

        if (instance==null) {


            synchronized (singletonThread.class) {
                if(instance==null){
                    instance = new singletonThread();
                }

            }
        }
        return instance;
    }

    public static void main (String[] args){
        singletonThread s1 = singletonThread.getInstance();
        singletonThread s2 = singletonThread.getInstance();


        System.out.println( s1==s2);
    }
}