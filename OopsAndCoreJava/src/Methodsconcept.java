
interface Notifications {

    // ABSTRACT METHOD:
    // Implementing classes provide the actual sending logic.
    void send(String message);

    // DEFAULT METHOD:
    // Inherited by implementing classes.
    // Can call abstract methods and private instance helpers.
    default void sendWelcome(String name) {
        String message = format("Welcome, " + name);
        send(message);
    }

    // PUBLIC STATIC METHOD:
    // Called using Notification.isValid(...).
    // Does not need a Notification object.
    static boolean isValid(String message) {
        return !isBlank(message);
    }

    // PRIVATE INSTANCE METHOD:
    // Only usable inside this interface.
    // Helps default methods reuse implementation details.
    private String format(String message) {
        return "[Notification] " + message;
    }

    // PRIVATE STATIC METHOD:
    // Internal helper usable by static and instance methods.
    private static boolean isBlank(String message) {
        return message == null || message.trim().isEmpty();
    }
}

class EmailNotification implements Notifications {

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }

    // sendWelcome() is inherited.
    // We could override it here if different behavior were needed.
}

public class Methodsconcept {
    public static void main(String[] args) {
        Notifications notification = new EmailNotification();

        // DEFAULT: called through an object.
        notification.sendWelcome("Jyoti");
        // Output: Email: [Notification] Welcome, Jyoti

        // STATIC: called through the declaring interface.
        System.out.println(Notifications.isValid("Hello")); // true

        // INVALID: interface static methods are not inherited.
        // notification.isValid("Hello");
        // EmailNotification.isValid("Hello");

        // INVALID: private methods are inaccessible outside the interface.
        // notification.format("Hello");
        // Notification.isBlank("Hello");
    }
}