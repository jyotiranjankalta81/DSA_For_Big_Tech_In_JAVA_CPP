



abstract class Animals {

    // Constructor
    Animals() {
        System.out.println("Animal constructor");
    }

    // Abstract method: no body
    abstract void sound();

    // Concrete method: has a body
    void sleep() {
        System.out.println("Sleeping");
    }
}

class Dogs extends Animals {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

// ABSTRACTION:
// This interface exposes WHAT an account can do.
// It does not reveal HOW the balance is stored,
// how withdrawals are validated, or how fees are calculated.
interface Account {
    void deposit(int amount);
    void withdraw(int amount);
    int getBalance();
}
// Implements the operations promised by Account.
class SavingsAccount implements Account {

    // ENCAPSULATION — protecting internal state:
    // These fields hold the account's internal data.
    // Code outside this class cannot access them directly.
    private final String accountHolder;
    private int balance;

    // Implementation detail: the fee used by this account.
    // Callers do not need to calculate or apply it themselves.
    private static final int WITHDRAWAL_FEE = 2;


    public SavingsAccount(String accountHolder, int openingBalance) {
        // ENCAPSULATION also means maintaining valid state.
        // An account cannot begin with a negative balance.
        if (openingBalance < 0) {
            throw new IllegalArgumentException(
                    "Opening balance cannot be negative"
            );
        }

        this.accountHolder = accountHolder;
        this.balance = openingBalance;
    }


    @Override
    public void deposit(int amount) {
        validateAmount(amount);

        // Only code inside this class directly changes balance.
        balance += amount;
    }


    @Override
    public void withdraw(int amount) {
        // ABSTRACTION — hiding implementation complexity:
        // The caller requests withdraw(amount).
        // This class handles the individual steps internally.

        // Step 1: Validate the requested amount.
        validateAmount(amount);

        // Step 2: Calculate the total including the fee.
        int totalDeduction = calculateTotalDeduction(amount);

        // Step 3: Protect the account from an invalid state.
        if (totalDeduction > balance) {
            throw new IllegalArgumentException(
                    "Insufficient balance, including withdrawal fee"
            );
        }

        // Step 4: Update the internal state.
        balance -= totalDeduction;
    }


    // ENCAPSULATION — restricting access to implementation:
    // Outside code cannot call this helper directly.
    // It is an internal step used by public operations.
    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero"
            );
        }
    }


    // Hidden implementation detail.
    // Fee calculation can change without changing the
    // public withdraw(int amount) method signature.
    private int calculateTotalDeduction(int amount) {
        return amount + WITHDRAWAL_FEE;
    }


    @Override
    public int getBalance() {
        // Controlled read access to private state.
        // Returning an int gives the caller a copy of the value.
        return balance;
    }


    public String getAccountHolder() {
        return accountHolder;
    }

    // Intentionally no setBalance(int amount).
    // A public setter allowing arbitrary values would bypass
    // deposit/withdraw validation and weaken encapsulation.
}


public class AbstractConcept {
    public static void main(String[] args) {

        // Account is the abstraction.
        // SavingsAccount provides the concrete implementation.
        Account account = new SavingsAccount("Jyoti", 1000);

        // Caller knows WHAT these operations do.
        // Caller does not manage the internal balance updates.
        account.deposit(500);
        account.withdraw(200);

        // Calculation handled internally:
        // 1000 + 500 - (200 + 2 fee) = 1298
        System.out.println("Balance: " + account.getBalance());


        // Reading a value does not give access to the field itself.
        int balanceCopy = account.getBalance();
        balanceCopy = -999;

        // The account's actual balance is unchanged.
        System.out.println(
                "Balance after changing copy: " + account.getBalance()
        );


        // Even using the concrete class does not bypass privacy.
        SavingsAccount savings = new SavingsAccount("Alex", 500);

        // These would cause compilation errors if uncommented:

        // savings.balance = -1000;
        // Cannot directly modify private internal state.

        // System.out.println(savings.balance);
        // Cannot directly read a private field.

        // savings.validateAmount(100);
        // Cannot access a private implementation method.

        // savings.calculateTotalDeduction(100);
        // Cannot call an internal calculation directly.


        // Public operations still enforce business rules.
        try {
            account.withdraw(5000);
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal rejected: " + e.getMessage());
        }

        // Failed withdrawal did not change the balance.
        System.out.println("Final balance: " + account.getBalance());


        // Animals animals = new Animals(); // Error: cannot instantiate abstract class

        Animals animal = new Dogs(); // Valid: reference points to a concrete subclass
        animal.sound();            // Bark
        animal.sleep();            // Sleeping
    }
}


/*

1. Instantiated = creating an object from a class
// Animal animal = new Animal(); // Error if Animal is abstract
Animal animal = new Dog();      // Valid: creates a Dog object


2. Concrete method = a method with a body
void sleep() {
    System.out.println("Sleeping");
}

Concrete implementation = the actual code that fulfills a declared behavior
If an abstract method says “an animal must make a sound,” the concrete implementation specifies how that animal makes its sound.

abstract class Animal {
    abstract void sound(); // Required behavior, no implementation

    void sleep() {         // Concrete method: shared implementation
        System.out.println("Sleeping");
    }
}

class Dog extends Animal {
    @Override
    void sound() {         // Concrete implementation of sound()
        System.out.println("Bark");
    }
}

Dog dog = new Dog(); // Instantiate the concrete class Dog
dog.sound();        // Runs Dog's implementation → Bark
dog.sleep();        // Runs the inherited concrete method → Sleeping



Abstraction means exposing what an object can do while hiding how it does it.
 The caller uses a simple contract without needing to understand the implementation.


 Abstraction means exposing what an object can do while hiding how it does it. The caller uses a simple contract without needing to understand the implementation.
Think of driving a car: you use the accelerator to increase speed without knowing how the engine controls fuel injection.
In Java, abstraction is commonly achieved using interfaces and abstract classes.


An abstract class is a class you cannot instantiate directly. It provides a common base that subclasses can extend.
An abstract method declares what a method must do through
its name, parameters, and return type, but has no implementation. A concrete subclass must provide that implementation.


An abstract class can have zero abstract methods.
A class containing an abstract method must be abstract.
A subclass must implement all inherited abstract methods, or remain abstract itself.
An abstract class can have constructors to initialize shared state.
An abstract method cannot be private, static, or final—those modifiers prevent the overriding it requires.
An abstract class cannot be final, because that would prevent subclassing.
 */