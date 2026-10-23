


/*
An interface in Java defines a contract: it specifies operations that implementing classes must support.
For example, an Account interface says that an account must support depositing and withdrawing money.
 Each class decides how to implement those operations.

 A class uses implements to follow that contract:
 */



// First capability
interface Printable {
    void print(); // Implicitly public abstract
}

// Second capability
interface Scannable {
    void scan(); // Implicitly public abstract
}


// CASE 1: A CLASS implements multiple interfaces.
// It must provide implementations for both required methods.
class MultiFunctionPrinter implements Printable, Scannable {

    @Override
    public void print() {
        System.out.println("MultiFunctionPrinter: Printing");
    }

    @Override
    public void scan() {
        System.out.println("MultiFunctionPrinter: Scanning");
    }
}


// CASE 2: An INTERFACE extends multiple interfaces.
// It combines their contracts without implementing their methods.
interface AllInOne extends Printable, Scannable {

    // Inherits print() and scan(), and adds copy().
    void copy();
}


// A concrete class implementing AllInOne must implement
// print(), scan(), and copy().
class OfficeMachine implements AllInOne {

    @Override
    public void print() {
        System.out.println("OfficeMachine: Printing");
    }

    @Override
    public void scan() {
        System.out.println("OfficeMachine: Scanning");
    }

    @Override
    public void copy() {
        System.out.println("OfficeMachine: Copying");
        scan();
        print();
    }
}


public class InterfaceConcept {
    public static void main(String[] args) {

        System.out.println("--- Class implements multiple interfaces ---");

        MultiFunctionPrinter machine = new MultiFunctionPrinter();

        // Concrete-class reference can access both public methods.
        machine.print();
        machine.scan();

        // Both interface references point to the SAME object.
        Printable printer = machine;
        Scannable scanner = machine;

        printer.print();
        // printer.scan(); // Error: Printable does not declare scan()

        scanner.scan();
        // scanner.print(); // Error: Scannable does not declare print()


        System.out.println("--- Interface extends multiple interfaces ---");

        AllInOne office = new OfficeMachine();

        // AllInOne includes all three operations.
        office.print();
        office.scan();
        office.copy();

        // Also valid: AllInOne extends Printable and Scannable.
        // These references point to the SAME OfficeMachine object.
        Printable officePrinter = office;
        Scannable officeScanner = office;

        officePrinter.print();
        officeScanner.scan();

        // officePrinter.copy(); // Error: Printable has no copy()
        // officeScanner.copy(); // Error: Scannable has no copy()
    }
}

/*
Key rules:
- An interface has no constructors and cannot be instantiated directly.
- A concrete implementing class must provide or inherit implementations of all required abstract methods.
- A class can implement multiple interfaces.
- An interface can extend multiple interfaces.
 */



/*
an interface can contain fields that are always public static final and five kinds of methods.

interface Config {
    int MAX_RETRIES = 3;
    // Equivalent to:
    // public static final int MAX_RETRIES = 3;
}

Interface fields:
- Must have an initializer.
- Belong to the interface, not individual objects.
- Cannot be reassigned.
- Cannot be instance fields, private, or protected.


System.out.println(Config.MAX_RETRIES); // 3
// Config.MAX_RETRIES = 5;               // Compile-time error


 */

interface Notification {

    // 1. Abstract: implicitly public abstract
    void send(String message);

    // 2. Default: implicitly public; can be overridden
    default void sendWelcome() {
        String message = format("Welcome");
        send(message);
    }

    // 3. Public static: belongs to the interface
    static boolean isValid(String message) {
        return !isBlank(message);
    }

    // 4. Private instance: internal helper
    private String format(String message) {
        return "[Notification] " + message;
    }

    // 5. Private static: internal helper
    private static boolean isBlank(String message) {
        return message == null || message.trim().isEmpty();
    }
}


/*
Reference type (Animal): the declared type of the variable. It determines what members the compiler lets you access.
Actual object type (Dog): the class of the object created at runtime. It determines which overridden instance method runs.
Reference (animal’s value): the value that refers to the object. The variable does not contain the object itself.


When two unrelated interfaces provide a default method with the same signature, the implementing class must override that method to resolve the conflict.
A default method is an interface method that already has an implementation.


A marker interface is an interface with no methods or fields, used to mark a class as having a particular capability or meaning.
It tells Java or other code: “Treat objects of this class in a special way.”



 */

