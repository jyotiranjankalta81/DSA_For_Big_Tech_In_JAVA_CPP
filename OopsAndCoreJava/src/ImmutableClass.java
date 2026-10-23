/*



An immutable class is a class whose objects cannot have their state changed after construction.
For example, if an immutable Person object is created
with the name "Jyoti" and age 25, that object keeps those values throughout its lifetime.
 */

import java.util.*;

// final prevents subclasses from introducing mutable behavior.
final class Person {

    // private: outside code cannot access fields directly.
    // final: fields cannot be reassigned after initialization.
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Returns a NEW object with the requested age.
    // Does not modify the current object.
    public Person withAge(int newAge) {
        return new Person(name, newAge);
    }
}


class Student {
    private final String name;

    // final prevents replacing the list.
    // The ArrayList itself remains mutable.
    private final List<String> subjects;

    public Student(String name, List<String> subjects) {
        this.name = name;

        // Copy the input so outside changes don't affect our internal list.
        this.subjects = new ArrayList<>(subjects);
    }

    // These methods make Student mutable.
    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public void removeSubject(String subject) {
        subjects.remove(subject);
    }

    public List<String> getSubjects() {
        // Return a copy to keep modifications controlled by Student's methods.
        return new ArrayList<>(subjects);
    }
}


// Prevent subclasses from breaking immutability.
final class School {

    private final Map<Integer, String> students;

    public School(Map<Integer, String> students) {
        // 1. Copy: changes to the input map won't affect this object.
        // 2. Wrap: prevent modifications through this field or its getter.
        this.students =
                Collections.unmodifiableMap(new HashMap<>(students));
    }

    public Map<Integer, String> getStudents() {
        // Safe to return: unmodifiable map with immutable keys and values.
        return students;
    }

    // No methods that change students.
}


 final class Employe {

    // String and Integer are immutable.
    private final String name;

    // final prevents reassignment.
    // Map.copyOf() also prevents changes to the map's entries.
    private final Map<String, Integer> skills;

    public Employe(String name, Map<String, Integer> skills) {
        this.name = name;

        // Store an unmodifiable snapshot.
        // Later changes to the caller's map cannot affect this object.
        this.skills = Map.copyOf(skills);
    }

    public String getName() {
        // Safe to return directly because String is immutable.
        return name;
    }

    public Map<String, Integer> getSkills() {
        // Safe to return directly:
        // the map is unmodifiable, and its keys/values are immutable.
        return skills;
    }

}


public class ImmutableClass {
    public static void main(String[] args) {
        Person original = new Person("Jyoti", 25);

        Person updated = original.withAge(26);

        System.out.println(original.getAge()); // 25 — unchanged
        System.out.println(updated.getAge());  // 26 — new object

        // original.age = 30;    // Error: private field
        // original.setAge(30); // Error: no setter exists

            Student student = new Student(
                    "Jyoti",
                    List.of("Java", "SQL")
            );

            student.addSubject("Spring Boot");
            System.out.println(student.getSubjects());
            // [Java, SQL, Spring Boot]

            student.removeSubject("SQL");
            System.out.println(student.getSubjects());
            // [Java, Spring Boot]

            List<String> copy = student.getSubjects();
            copy.clear(); // Changes only the returned copy.

            System.out.println(student.getSubjects());
            // [Java, Spring Boot]



        Map<Integer, String> input = new HashMap<>();
        input.put(101, "Jyoti");
        input.put(102, "Alex");

        School school = new School(input);

        // Changing the original map does not affect School.
        input.put(103, "Sam");

        System.out.println(school.getStudents().containsKey(103));
        // false

        // Attempting to modify the returned map is blocked.
        try {
            school.getStudents().put(104, "Ravi");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot modify the students map");
        }

        System.out.println(school.getStudents().get(101)); // Jyoti




        Map<String, Integer> originalSkills = new HashMap<>();
        originalSkills.put("Java", 5);

        Employe employee = new Employe("Jyoti", originalSkills);

        // Changing the original map does not change Employee.
        originalSkills.put("Java", 10);

        System.out.println(employee.getSkills().get("Java")); // 5

        // Changing the map returned by the getter is blocked.
        try {
            employee.getSkills().put("Spring", 4);
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot modify employee skills");
        }

        // No setter exists:
        // employee.setName("Alex"); // Compile-time error

    }
}


/*
To design an immutable class:
1. Keep fields private to control access.
2. Make fields final so they cannot be reassigned after initialization.
3. Initialize state during construction.
4. Provide no methods that modify the object’s state.
5. Prevent subclasses from breaking immutability, commonly by making the class final.
6. Protect mutable fields with defensive copies when accepting
 or returning them. A final reference to a mutable list or array does not prevent its contents from changing.
 */


/*
o create a custom immutable class, make sure its state cannot change after construction—including any mutable objects it contains.
Follow these rules:
1. Make the class final to prevent subclasses from changing its behavior.
2. Make fields private final.
3. Initialize fields in the constructor.
4. Do not provide setters or other methods that modify state.
5. Make defensive copies of mutable inputs.
6. Do not expose mutable internal objects through getters.
 */