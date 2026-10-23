
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrimitivesAndWrapperClasses {
    public static void main(String[] args) {

        // 1. ALL EIGHT PRIMITIVES AND THEIR WRAPPERS
        // Wrapper classes belong to java.lang; no imports are needed.
        Byte byteValue = 10;            // byte → Byte
        Short shortValue = 100;         // short → Short
        Integer intValue = 1000;        // int → Integer
        Long longValue = 1000L;         // long → Long
        Float floatValue = 10.5f;       // float → Float
        Double doubleValue = 10.5;      // double → Double
        Character charValue = 'A';      // char → Character
        Boolean boolValue = true;      // boolean → Boolean


        // 2. AUTOBOXING: Primitive → wrapper automatically
        int primitive = 25;
        Integer boxed = primitive;

        // Explicit boxing: prefer valueOf().
        Integer explicitBoxed = Integer.valueOf(25);


        // 3. UNBOXING: Wrapper → primitive automatically
        int unboxed = boxed;

        // Explicit unboxing:
        int explicitUnboxed = boxed.intValue();

        System.out.println(unboxed);         // 25
        System.out.println(explicitUnboxed); // 25


        // 4. WRAPPERS IN COLLECTIONS
        // Generics require reference types.
        // List<int> invalid; // Compilation error

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);             // Autoboxing: int → Integer
        int first = numbers.get(0);  // Unboxing: Integer → int

        System.out.println(first); // 10


        // 5. NULL AND UNBOXING
        // Wrappers can hold null; primitives cannot.
        Integer missing = null;

        // Each would throw NullPointerException:
        // int value = missing;
        // int next = missing + 1;
        // boolean zero = missing == 0;
        // missing++;

        System.out.println(missing == null); // true: no unboxing

        // Supply a default if appropriate for your application.
        int safeValue = (missing != null) ? missing : 0;
        System.out.println(safeValue); // 0

        // Short-circuiting prevents unboxing null.
        if (missing != null && missing > 0) {
            System.out.println("Positive");
        }

        Boolean enabled = null;
        // if (enabled) { } // NullPointerException: unboxing null

        System.out.println(Boolean.TRUE.equals(enabled)); // false


        // 6. WRAPPER CACHING
        // valueOf() reuses objects for common values.
        //
        // Byte:      all values (-128 to 127)
        // Short:     -128 to 127
        // Integer:   at least -128 to 127
        // Long:      -128 to 127
        // Character: at least 0 to 127
        // Boolean:   true and false
        // Float/Double: no guaranteed object cache

        Integer a = 100;
        Integer b = 100;

        System.out.println(a == b); // true: same cached object

        Integer c = 200;
        Integer d = 200;

        // Usually false, but may be true with an extended Integer cache.
        System.out.println(c == d);

        // Always true: compares Integer values.
        System.out.println(c.equals(d)); // true


        // 7. == VERSUS equals()
        // Wrapper == wrapper: compares object identity.
        // Wrapper == primitive: unboxes and compares numeric values.

        Integer number = 200;
        int numericValue = 200;

        System.out.println(number == numericValue); // true: unboxing

        // Null-safe value comparison for wrappers of the same type:
        System.out.println(Objects.equals(c, d));          // true
        System.out.println(Objects.equals(missing, c));    // false
        System.out.println(Objects.equals(missing, null)); // true

        // Numeric wrapper equals() also requires the same wrapper type.
        Integer integerOne = 1;
        Long longOne = 1L;

        System.out.println(integerOne.equals(longOne)); // false
        System.out.println(
                integerOne.longValue() == longOne.longValue()
        ); // true: comparing primitive long values


        // 8. parseInt() VERSUS valueOf()
        // parseInt(String) returns primitive int.
        int parsed = Integer.parseInt("123");

        // valueOf(String) returns an Integer object.
        Integer wrapped = Integer.valueOf("123");

        // valueOf(int) boxes an existing primitive value.
        Integer fromPrimitive = Integer.valueOf(123);

        System.out.println(parsed);        // 123
        System.out.println(wrapped);       // 123
        System.out.println(fromPrimitive); // 123

        // Parsing other types:
        double price = Double.parseDouble("99.50");
        boolean active = Boolean.parseBoolean("true");

        // Parsing with a radix (number base):
        int binary = Integer.parseInt("1010", 2);
        int hexadecimal = Integer.parseInt("FF", 16);

        System.out.println(binary);      // 10
        System.out.println(hexadecimal); // 255

        // Invalid or out-of-range integer text causes NumberFormatException.
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException exception) {
            System.out.println("Invalid integer");
        }

        // Boolean parsing is different:
        // Only "true", ignoring case, produces true.
        System.out.println(Boolean.parseBoolean("TRUE")); // true
        System.out.println(Boolean.parseBoolean("yes"));  // false
        System.out.println(Boolean.parseBoolean(null));   // false


        // 9. WRAPPER IMMUTABILITY
        Integer original = 10;
        Integer shared = original;

        original++;
        // Effectively:
        // original = Integer.valueOf(original.intValue() + 1);
        //
        // The original object is unchanged.
        // The variable is reassigned to an object representing 11.

        System.out.println(original); // 11
        System.out.println(shared);   // 10

        // final additionally prevents variable reassignment.
        final Integer fixed = 10;
        // fixed = 20; // Compilation error
        // fixed++;   // Compilation error: requires reassignment

        // Immutability supports safe caching, stable hash keys,
        // and safe sharing of the object's value between threads.
        // However, updating a shared Integer variable with ++ is NOT atomic.


        // 10. COMPARING NUMERIC ORDER
        // compareTo(): negative if smaller, zero if equal, positive if larger.
        System.out.println(Integer.valueOf(10).compareTo(20)); // -1
        System.out.println(Integer.valueOf(10).compareTo(10)); // 0
        System.out.println(Integer.valueOf(20).compareTo(10)); // 1

        // Static comparison avoids boxing primitive arguments.
        System.out.println(Integer.compare(10, 20)); // -1


        // 11. CONVERTING BACK TO TEXT
        String text1 = Integer.toString(123);
        String text2 = wrapped.toString();

        System.out.println(text1); // 123
        System.out.println(text2); // 123


        // 12. NUMERIC CONVERSIONS CAN LOSE INFORMATION
        Integer large = 130;
        byte narrowed = large.byteValue();

        System.out.println(narrowed); // -126: outside byte's range


        // 13. USEFUL CONSTANTS AND UTILITY METHODS
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.SIZE);      // 32 bits for primitive int

        System.out.println(Character.isDigit('7'));  // true
        System.out.println(Character.isLetter('A')); // true

        // Prefer primitives for ordinary calculations when null is unnecessary.
        // Use wrappers when objects are required, such as in generic collections.
    }
}