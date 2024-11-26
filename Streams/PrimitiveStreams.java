package Streams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        int[] ia = { 1, 2, 3 };
        double[] da = { 1.1, 2.2, 3.3 };
        long[] la = { 1L, 2L, 3L };

        IntStream iStream = Arrays.stream(ia);
        DoubleStream doubleStream = Arrays.stream(da);
        LongStream longStream = Arrays.stream(la);

        // sysout all the strem counts
        System.out.println("IntStream count: " + iStream.count() + " DoubleStream count: " + doubleStream.count()
                + " LongStream count: " + longStream.count());

        IntStream iStream2 = IntStream.of(1, 2, 3);

        DoubleStream doubleStream2 = DoubleStream.of(1.1, 2.2, 3.3);

        LongStream longStream2 = LongStream.of(1L, 2L, 3L);

        System.out.println("IntStream count: " + iStream2.count() + " DoubleStream count: " + doubleStream2.count()
                + " LongStream count: " + longStream2.count());

        // Reduce operation
        IntStream intStream = Stream.of(1, 2, 3).mapToInt(n -> n);
        int total = intStream.sum();
        System.out.println(total);

        // Common primitive stream methods
        OptionalInt max = IntStream.of(10, 20, 30).max();
        max.ifPresent(System.out::println);
        OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0).min();
        System.out.println(min.orElseThrow());
        OptionalDouble average = LongStream.of(10L, 20L, 30L).average();
        System.out.println(average.orElseGet(() -> Math.random()));

        
    }
}
