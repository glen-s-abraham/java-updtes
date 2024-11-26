package Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Cat {
    // private name,color
    private String name;
    private String color;

    // constructor
    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // to string metods
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}

public class CreateStream {
    public static void main(String[] args) {
        // Array.stream()
        Double[] numbers = { 1.1, 2.2, 3.3 };
        Stream<Double> stream1 = Arrays.stream(numbers);
        long n = stream1.count();
        System.out.println(n);

        // collection interface method
        List<String> animalList = Arrays.asList("cat", "dog", "sheep");
        Stream<String> streamAnimals = animalList.stream();
        System.out.println(streamAnimals.count());

        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("John", 25);
        namesToAges.put("Jakes", 25);
        System.out.println(namesToAges.entrySet().stream().count());

        // Stream.of
        Stream<String> stream2 = Stream.of("cat", "dog", "sheep");
        System.out.println(stream2.count());

        System.out.println(loadcats("C:\\Users\\iss211\\java updates\\Streams\\cats.txt"));

    }

    public static List<Cat> loadcats(String filename) {
        List<Cat> cats = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(line -> {
                String[] cat = line.split("/");
                cats.add(new Cat(cat[0], cat[1]));
            });
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cats;
    }
}