public class immutability {


    public static void main (String [] args){
        String text = "Hello";

        text.concat(" Java");

        System.out.println(text); // Hello


        String name = "Java";
        name.concat(" Programming");

        System.out.println(name); // Java — original String unchanged

        name = name.concat(" Programming");
        System.out.println(name); // Java Programming

        String first = "Java";
        String second = "Java";               // Same pooled object
        String third = "python";     // Separate object
        String fourth = second.intern();

        // Identity hash codes in decimal (integer format).
        System.out.println("first:  " + System.identityHashCode(first));
        System.out.println("second: " + System.identityHashCode(second));
        System.out.println("third:  " + System.identityHashCode(third));
        System.out.println("fourth " + fourth);




// The variable now refers to another String.
// The original "Java" object was never modified.
    }
}



/*
- Immutable: To represent changed data, use another object.
- Mutable: You can change the existing object’s data.
final stops a variable from being reassigned; immutability stops an object’s state from changing.


String is immutable because Java’s designers made its contents unchangeable after creation.
This allows strings to be safely shared and makes them reliable for security, collections, and concurrent code.




Safe sharing through the string pool
Java can reuse the same string object for identical literals. Because its contents cannot change, one user of that object cannot affect another.
String a = "Java";
String b = "Java"; // Same pooled object as a


Security
Strings represent filenames, usernames, and connection URLs. Once code receives a string, another reference to that same object cannot change its contents after validation.

Thread safety
Multiple threads can safely read the same string object because none can modify its contents. No synchronization is needed to protect those contents.

Reliable keys in collections
A HashMap key needs stable equality and hashing while stored in the map. A string’s contents never change, so its hash code and equality behavior stay consistent.

Performance through hash-code caching
After calculating its hash code, a string can reuse the cached result. This avoids repeatedly calculating it during operations such as map lookups.
 */



/*

A string literal is text written inside double quotes, such as "Java" or "Hello".
Java uses a string pool to share one string object among identical literals, instead of creating a separate object for every occurrence.
Consider this:
String first = "Java";
String second = "Java";
String third = "Python";

Here is what happens conceptually:
1. String first = "Java";
   Java uses the pooled string containing "Java". If it is not already pooled, it is added. first receives a reference to that object.
2. String second = "Java";
   The same content is already pooled, so second receives a reference to the same object.
3. String third = "Python";
   This has different content, so third refers to a different pooled object.

 */



/*
1. String literals reuse pooled objects.
2. new String() creates a separate object.
3. intern() returns the pooled reference
intern() looks for an equal string in the pool:
- If one exists, it returns that existing reference.
- Otherwise, it adds this string to the pool and returns its reference.

 */

/*
String is immutable. StringBuilder is mutable and unsynchronized,
 making it suitable for building text within one thread.
 StringBuffer is mutable and synchronized, supporting shared access,
  although compound operations may still require external synchronization
 */