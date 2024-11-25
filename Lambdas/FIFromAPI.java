package Lambdas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FIFromAPI {
    public static void main(String[] args) {
        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Vatican City"));

        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican", 5));
        System.out.println(checkLength.test("Vatican City", 12));

        supplier();
        consumer();
        function();
        unaryBinaryOperator();
    }

    public static void supplier() {
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("supplier SB" + supSB.get().append("SK"));

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("supplier Time" + supTime.get());

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println("supplier Random" + sRandom.get());
    }

    public static void consumer() {
        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("Hello");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("mary");
        names.forEach(printC);

        var mapCapitalCities = new HashMap<String, String>();
        mapCapitalCities.put("France", "Paris");
        mapCapitalCities.put("Washington D.C", "USA");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) -> System.out
                .println(key + " " + "is the capital of" + " " + value);

        mapCapitalCities.forEach(mapPrint);

    }

    public static void function() {
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println(fn2.apply("Vatican City"));

        BiFunction<String, String, Integer> biFun = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction:" + " " + biFun.apply("William", "Shakespeare"));

        BiFunction<String, String, String> biFun2 = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction:" + " " + biFun2.apply("William", "Shakespeare"));
    }

    public static void unaryBinaryOperator() {
        // Input and output types must match
        UnaryOperator<String> unaryOp = name -> "My name is " + name;
        System.out.println(unaryOp.apply("John"));

        // Input and output types must match
        BinaryOperator<String> binaryOp = (s1, s2) -> s1.concat(s2);
        System.out.println(binaryOp.apply("William", "Shakespeare"));
    }
}
