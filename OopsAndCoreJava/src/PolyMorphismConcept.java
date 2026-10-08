 class PolyMorphismConceptv1 {
}

public class PolyMorphismConcept {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        PolyMorphismConcept calc = new PolyMorphismConcept();

        System.out.println(calc.add(2, 3));
        System.out.println(calc.add(2.5, 3.5));
    }
}




/*
Polymorphism means “many forms.” In Java, it lets the same method name or common type support different behavior.

| Type                             | Achieved through                       | Method selection |
|----------------------------------|----------------------------------------|----------------------------------------|
| **Compile-time polymorphism**    | Method overloading                     | At compile time, based on argument types |
| **Runtime polymorphism**         | Method overriding                      | At runtime, based on the actual object |



1. Compile-time polymorphism — overloading
Methods have the same name but different parameter lists.

The compiler selects the matching method. Changing only the return type is not enough to overload a method.


2. Runtime polymorphism — overriding
Child classes provide different implementations of a parent method.


The expression animal.sound() stays the same, but its behavior changes depending on the object.
- Reference type (Animal) determines which methods are available at compile time.
- Actual object type (Dog or Cat) determines which overridden implementation runs.


You can add another animal without changing makeSound(). The same principle works
 with interfaces—for example, calling pay() through a Payment interface implemented by different payment providers.
 */
