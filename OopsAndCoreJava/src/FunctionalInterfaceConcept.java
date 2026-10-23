


@FunctionalInterface
interface Calculator {

    // The single abstract method
    int calculate(int a, int b);

    // Allowed: a method with an implementation
    default void showDescription() {
        System.out.println("Performs a calculation");
    }
}

public class FunctionalInterfaceConcept {
    public static void main(String[] args) {

        // Lambda provides the implementation of calculate().
        Calculator addition = (a, b) -> a + b;
        Calculator multiplication = (a, b) -> a * b;

        System.out.println(addition.calculate(10, 5));       // 15
        System.out.println(multiplication.calculate(10, 5)); // 50

        addition.showDescription(); // Performs a calculation
    }
}

/*
A functional interface is a Java interface with exactly one abstract method.
It can be implemented using a lambda expression.
It may also contain default, static, and private methods because those have implementations
 and do not count toward the abstract-method limit.
 */