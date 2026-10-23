

abstract class Accounts {

    // FIELD: Each account object has its own balance.
    private int balance;

    // CONSTRUCTOR: Initializes the parent part of a subclass object.
    protected Accounts(int openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Invalid opening balance");
        }

        this.balance = openingBalance;
        System.out.println("Account constructor");
    }

    // CONCRETE METHOD: Has an implementation that subclasses inherit.
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        balance += amount;
    }

    // CONCRETE METHOD: Provides controlled access to private state.
    public int getBalance() {
        return balance;
    }

    // ABSTRACT METHOD: Subclasses must provide an implementation,
    // unless they are also abstract.
    public abstract void printAccountType();
}

class SavingsAccounts extends Accounts {

    public SavingsAccounts(int openingBalance) {
        // Calls the abstract parent class's constructor.
        super(openingBalance);
        System.out.println("SavingsAccount constructor");
    }

    @Override
    public void printAccountType() {
        System.out.println("Savings account");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        // Account account = new Account(1000); // Not allowed

        Accounts account = new SavingsAccounts(1000);

        account.deposit(500);     // Inherited concrete method
        account.printAccountType(); // Subclass implementation
        System.out.println(account.getBalance());
    }
}



/*
Yes— a static field is shared at the class level. All objects accessing that same static field see the same variable.
My earlier phrase “shared state” was ambiguous:
- Instance fields: each object has its own state, defined in the abstract parent.
- Static fields: one variable belongs to the class and is shared across its instances, including subclass instances.
Being abstract does not change how static works.
 */
