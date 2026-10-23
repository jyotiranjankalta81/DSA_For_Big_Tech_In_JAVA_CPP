public class OOPSRelation {
}


/*
Relationship	            Meaning	                                         Example
Association	                One object knows or uses another	             A teacher teaches a student
Aggregation	                A whole groups independent objects	             A team has players
Composition	                A whole owns parts whose lifecycle it controls	 A house has rooms
 */



/*
SOLID is a set of five object-oriented design principles that help make code easier to change, test, and maintain.


| Principle                                        | Simple meaning |
|----------------------------------------------|------------------------------------------------------------|
| **S — Single Responsibility**                | A class should have one reason to change |
| **O — Open/Closed**                          | Extend behavior without repeatedly modifying existing code |
| **L — Liskov Substitution**                  | A subtype must honor the behavior promised by its parent type |
| **I — Interface Segregation**                | Clients should not depend on methods they do not need |
| **D — Dependency Inversion**                 | High-level policy and implementation details should depend on abstractions |
 */


/*
1. S — Single Responsibility Principle
Keep responsibilities that change for different reasons separate.
For example, one class should not handle report calculations, database storage, and email delivery.


2. O — Open/Closed Principle
Classes should be open for extension, closed for modification.
Instead of editing a notification service every time you add a delivery channel, depend on an interface:

interface NotificationSender {
    void send(String message);
}

class EmailSender implements NotificationSender {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsSender implements NotificationSender {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}



3. L — Liskov Substitution Principle
A child object should be usable wherever its parent type is expected without breaking the promised behavior.
Suppose this interface promises that documents can be saved:


4. I — Interface Segregation Principle
Prefer focused interfaces so implementations and callers are not forced to depend on unrelated operations.


5. D — Dependency Inversion Principle
Business logic should depend on abstractions rather than directly creating specific infrastructure implementations.


 */