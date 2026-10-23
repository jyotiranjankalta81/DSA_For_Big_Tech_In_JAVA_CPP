


class Employee {

    // 1. STATIC FIELD: One variable shared by all Employee objects.
    static String company = "TechCorp";
    static int employeeCount = 0;

    // INSTANCE FIELD: Each Employee object has its own name.
    private String name;


    // 2. STATIC BLOCK: Runs once when Employee is initialized.
    // Static field initializers and blocks run in textual order.
    static {
        System.out.println("Static block: Initializing Employee");
        company = "OpenTech";
    }


    Employee(String name) {
        this.name = name;

        // Every new Employee updates the same class-level counter.
        employeeCount++;
    }


    // 3. STATIC METHOD: Can be called without an Employee object.
    static void showCompany() {
        System.out.println("Company: " + company);

        // System.out.println(name); // Error: needs an Employee object
        // System.out.println(this.name); // Error: no 'this' here
    }


    static void showEmployeeName(Employee employee) {
        // A static method CAN access instance fields
        // when an explicit object reference is provided.
        System.out.println("Employee name: " + employee.name);
    }


    // INSTANCE METHOD: Uses the current object's name.
    void showDetails() {
        System.out.println(name + " works at " + company);
    }


    // 4. STATIC NESTED CLASS:
    // Does not require an enclosing Employee object.
    static class IdCard {

        // This is an INSTANCE field of IdCard.
        // A static nested class does not make all its members static.
        private final int cardNumber;

        IdCard(int cardNumber) {
            this.cardNumber = cardNumber;
        }

        void printCard() {
            // Can directly access the enclosing class's static field.
            System.out.println("Card " + cardNumber + " | " + company);

            // System.out.println(name);
            // Error: no enclosing Employee object is available.
        }
    }
}


public class ImportantKeywords {
    public static void main(String[] args) {

        // No Employee objects exist yet.
        // This call triggers Employee initialization,
        // so the static block runs before showCompany().
        Employee.showCompany();

        Employee first = new Employee("Jyoti");
        Employee second = new Employee("Alex");

        first.showDetails();
        second.showDetails();

        System.out.println("Employee count: " + Employee.employeeCount);

        // Change the shared static field.
        Employee.company = "NewCorp";

        // Both objects now see the updated company.
        first.showDetails();
        second.showDetails();

        // Access an object's instance field through a static method.
        Employee.showEmployeeName(first);

        // Create a nested-class object without an enclosing Employee:
        // No first.new IdCard(...) or new Employee(...) is needed.
        Employee.IdCard card = new Employee.IdCard(101);
        card.printCard();

        // Static block does not run again.
        Employee.showCompany();
    }
}


/*
final prevents a specific kind of change: reassignment for variables, overriding for methods, and inheritance for classes.
Used                        on	Meaning
Variable             	Cannot be reassigned after initialization
Method	                Cannot be overridden by a subclass
Class	                Cannot be extended
 */




/*
A static method belongs to a class and can be called without creating an object.
An instance member is a non-static field or method that belongs to a particular object.
A static method needs an object reference to access it because it has no this—no current object.
 */

 class Employees {

    // STATIC FIELD:
    // One company variable shared by all Employee objects.
    private static String company = "Acme";

    // INSTANCE FIELD:
    // Each Employee object has its own name.
    private String name;

    // CONSTRUCTOR:
    // Initializes the name of the object being created.
    public Employees(String name) {
        this.name = name;
    }

    // INSTANCE METHOD:
    // Runs on a specific Employee object, so "this" is available.
    public void introduce() {
        // Can directly access this object's instance field.
        System.out.println("Name: " + name);

        // Instance methods can also access static fields.
        System.out.println("Company: " + company);
    }

    // STATIC METHOD:
    // Accesses another static member directly.
    public static void changeCompany(String newCompany) {
        company = newCompany;
    }

    // STATIC METHOD:
    // Receives an existing object and accesses its instance members.
    public static void printEmployee(Employees employee) {

        // INVALID: no current Employee object in a static method.
        // System.out.println(name);
        // introduce();
        // System.out.println(this.name);

        // VALID: explicitly identify the object whose name is needed.
        System.out.println("Selected employee: " + employee.name);

        // VALID: call an instance method on that particular object.
        employee.introduce();

        // Access to the private field is allowed here because
        // this code is inside the Employee class.
    }

    // STATIC METHOD:
    // Can also create an object and then access its instance members.
    public static void createTemporaryEmployee() {
        Employees temporary = new Employees("Temporary");

        // Both accesses use the newly created object.
        System.out.println(temporary.name);
        temporary.introduce();
    }

    // main is static: it can run without an Employee object.
    public static void main(String[] args) {

        // 1. Call a static method using the class name.
        // No Employee objects have been created yet.
        Employees.changeCompany("NewCorp");

        // 2. Create two objects, each with a different name.
        Employees first = new Employees("Jyoti");
        Employees second = new Employees("Alex");

        // 3. Access instance methods through object references.
        first.introduce();  // Uses first's name: Jyoti
        second.introduce(); // Uses second's name: Alex

        // 4. Pass an existing object into a static method.
        Employees.printEmployee(first);  // Reads Jyoti's details
        Employees.printEmployee(second); // Reads Alex's details

        // 5. A static method can modify an object's instance state
        // when it has a reference and access is permitted.
        first.name = "Jyoti Ranjan";
        Employees.printEmployee(first); // Reads the updated name

        // second is a different object, so its name is unchanged.
        System.out.println(second.name); // Alex

        // 6. A static method can create its own object.
        Employees.createTemporaryEmployee();
    }
}


// FINAL CLASS: Cannot be extended.
final class Settings {
    // STATIC FINAL: Class-level field that cannot be reassigned.
    public static final int MAX_RETRIES = 3;

    // A final class can still contain mutable state.
    private int timeout = 30;

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getTimeout() {
        return timeout;
    }
}

// class CustomSettings extends Settings { }
// Compilation error: cannot extend a final class.


class Parents {
    // FINAL METHOD: Subclasses inherit it but cannot override it.
    public final void show() {
        System.out.println("Parent final method");
    }
}

class Childs extends Parents {
    // @Override
    // public void show() { }
    // Compilation error: cannot override a final method.

    // OVERLOADING is allowed: different parameter list.
    public void show(String message) {
        System.out.println(message);
    }
}


 class ImportantKey {
    public static void main(String[] args) {

        // 1. FINAL PRIMITIVE VARIABLE
        final int age = 25;
        // age = 30; // Error: cannot reassign
        System.out.println("Age: " + age);

        // A final local variable can be assigned later, but only once.
        final int number;
        number = 10;
        // number = 20; // Error: already assigned
        System.out.println("Number: " + number);


        // 2. FINAL REFERENCE VARIABLE
        final StringBuilder text = new StringBuilder("Hello");

        // Allowed: modifies the existing object.
        text.append(" Java");
        System.out.println(text);

        // text = new StringBuilder("Bye");
        // Error: cannot point the final reference to a different object.

        // text = null; // Also an error: reassignment


        // 3. FINAL METHOD
        Childs child = new Childs();

        child.show(); // Inherited final method
        child.show("Overloaded method"); // Different method signature


        // 4. FINAL CLASS
        // Creating an object is allowed; extending the class is not.
        Settings settings = new Settings();

        // final class does NOT mean immutable object.
        settings.setTimeout(60);
        System.out.println("Timeout: " + settings.getTimeout());


        // 5. STATIC FINAL FIELD
        System.out.println("Max retries: " + Settings.MAX_RETRIES);

        // Settings.MAX_RETRIES = 5;
        // Error: cannot reassign a final field
    }
}


/*
Because final applies to the reference variable, not to the object’s internal state.
It means: “This variable must keep pointing to the same object.” It does not mean: “That object cannot change.”


class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        final Person person = new Person("Jyoti");

        // Allowed: changes the SAME object's internal state.
        person.name = "Alex";
        System.out.println(person.name); // Alex

        // Not allowed: makes the variable point to ANOTHER object.
        // person = new Person("Sam");

        // Not allowed: also reassigns the reference.
        // person = null;
    }
}
 */