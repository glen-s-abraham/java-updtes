package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

//class person with name age and constructor
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age
                + '}';
    }

}

public class IntermediateOperations {
    public static void main(String[] args) {
        // filter
        Stream.of("galway", "mayo", "roscommon")
                .filter(countyName -> countyName.length() > 5)
                .forEach(System.out::println);

        // distinct
        Stream.of("galway", "galway", "GALWAY")
                .peek(s -> System.out.println("1." + s))
                .distinct()
                .forEach(s -> System.out.println("2." + s));

        // limit
        Stream.of(11, 22, 33, 44, 55, 66, 77, 88, 99)
                .peek(n -> System.out.println("A - " + n))
                .filter(n -> n > 40)
                .peek(n -> System.out.println("B - " + n))
                .limit(2)
                .forEach(n -> System.out.println("C - " + n));

        // map
        Stream.of("galway", "mayo", "roscommon")
                .map(s -> s.length())
                .forEach(System.out::print);

        // flatmap
        List<String> list1 = Arrays.asList("Sean", "Desmond");
        List<String> list2 = Arrays.asList("Mary", "Ann");
        Stream<List<String>> streamOfLists = Stream.of(list1, list2);

        streamOfLists.flatMap(list -> list.stream())
                .forEach(System.out::print);

        // sorted
        Person john = new Person("John", 23);
        Person mary = new Person("mary", 25);

        Stream.of(john, mary).sorted(Comparator.comparing(p -> p.getAge()))
                .forEach(System.out::println);

        //Stream of names filter where length ==3 sorted and limted by2 and printed at last with peek in between all stpes
        Stream.of("John", "Mary", "David", "Peter", "John","Ann","Tim","Jim")
        .peek(System.out::println)
        .filter(name -> name.length() == 3)
        .peek(System.out::println)
        .sorted()
        .peek(System.out::println)
        .limit(2)
        .forEach(System.out::println);

    }

}
