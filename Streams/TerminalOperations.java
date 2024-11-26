package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        // count, min, max
        long count = Stream.of("dog", "cat").count();
        System.out.println(count);

        Optional<String> min = Stream.of("deer", "horse", "pig").min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        Optional<Integer> max = Stream.of(4, 6, 2, 12, 9).max((i1, i2) -> i1 - i2);
        max.ifPresent(System.out::println);

        // findAny, findFirst
        Optional<String> any = Stream.of("john", "paul", "george").findAny();
        any.ifPresent(System.out::println);

        Optional<String> first = Stream.of("john", "paul", "george").findFirst();
        first.ifPresent(System.out::println);

        // anyMatch, allMatch, noneMatch
        // Array list of names
        List<String> names = Arrays.asList("john", "paul", "george", "alan");

        Predicate<String> startsWithA = s -> s.startsWith("a");

        System.out.println(names.stream().anyMatch(startsWithA));

        System.out.println(names.stream().allMatch(startsWithA));

        System.out.println(names.stream().noneMatch(startsWithA));

        // foreach
        Stream<String> stream = Stream.of("john", "paul", "george");
        stream.forEach(System.out::println);

        // reduce
        String name = Stream.of("s", "e", "a", "n").reduce("", (s, c) -> s + c);
        System.out.println(name);

        Integer product = Stream.of(2, 3, 4).reduce(1, (a, b) -> a * b);
        System.out.println(product);

        BinaryOperator<Integer> op = (a, b) -> a + b;

        Stream<Integer> stream1 = Stream.empty();

        Stream<Integer> stream2 = Stream.of(1);

        Stream<Integer> stream3 = Stream.of(1, 2, 3);

        System.out.println(stream1.reduce(op).orElse(0));

        System.out.println(stream2.reduce(op).orElse(0));

        System.out.println(stream3.reduce(op).orElse(0));

        // Stream of animal names
        List<String> animalNames = Arrays.asList("dog", "cat", "bird", "fish");

        int length = animalNames.stream().reduce(0, (n, str) -> n + str.length(), (n1, n2) -> n1 + n2);
        System.out.println(length);

        // Collect
        StringBuilder word = Stream.of("ad", "jud", "i", "cate").collect(() -> new StringBuilder(),
                (sb, str) -> sb.append(str), (sb1, sb2) -> sb1.append(sb2));
        System.out.println(word);

        String s = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.joining(", "));
        System.out.println(s);

        Double avg = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.averagingInt(str -> str.length()));

        System.out.println(avg);

        Map<String, Integer> map = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.toMap(str -> str, str -> str.length()));
        System.out.println(map);

        Map<Integer, String> nMap = Stream.of("cake", "biscuits", "tart")
                .collect(Collectors.toMap(str -> str.length(), str -> str, (s1, s2) -> s1 + " " + s2));
        System.out.println(nMap);

        TreeMap<String, Integer> tmap = Stream.of("cake", "biscuits", "tart", "cake")
                .collect(Collectors.toMap(str -> str, str -> str.length(), (len1, len2) -> len1 + len2,
                        () -> new TreeMap<>()));

        System.out.println(tmap);

        Stream<String> employees = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, List<String>> emap = employees.collect(Collectors.groupingBy(String::length));
        System.out.println(emap);

        Stream<String> people = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Boolean, List<String>> peoplemap = people.collect(Collectors.partitioningBy(str -> str.startsWith("T")));
        System.out.println(peoplemap);

    }
}
