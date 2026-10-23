
@FunctionalInterface
interface Greeting {
    void greet(String name);
}

public class LambdaVsAnonymous {
    public static void main(String[] args) {

        // 1. ANONYMOUS CLASS: explicitly declares the method.
        Greeting anonymous = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Hello, " + name);
            }
        };

        // 2. LAMBDA: supplies the abstract method's implementation.
        Greeting lambda = name -> System.out.println("Hello, " + name);

        anonymous.greet("Jyoti"); // Hello, Jyoti
        lambda.greet("Jyoti");    // Hello, Jyoti
    }
}