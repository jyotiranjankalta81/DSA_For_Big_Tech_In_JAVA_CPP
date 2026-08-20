package Theories;
import  java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class functionalInterfaces {


    public static void main(String[] args){
        Function<String, Integer> length =
                str -> str.length();

        System.out.println(length.apply("Java"));

        Predicate<Integer> isEven =
                number -> number % 2 == 0;

        System.out.println(isEven.test(10));

//        generate a random no.
        Supplier<Double> random = ()->Math.random();
        System.out.println("random " + random);

        //consume a string without return
        Consumer<String > print = name-> System.out.println(name);
        System.out.println(print);
    }
}
