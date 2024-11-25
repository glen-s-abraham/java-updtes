package Lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class UnBoundMethodReferences {
    public static void main(String[] args) {

        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMr = String::toUpperCase;

        System.out.println(upperL.apply("sean"));
        System.out.println(upperMr.apply("sean"));

        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMr = String::concat;

        System.out.println(concatL.apply("Sean","Kennedy"));
        System.out.println(concatMr.apply("Sean","Kennedy"));

    }
}
