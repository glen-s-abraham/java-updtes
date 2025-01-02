package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Cat implements Comparable<Cat> {

    private String name;
    private Integer age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Cat) {
            Cat otherCat = (Cat) o;
            return (this.name != null && this.name.equals(otherCat.getName()))
                    && (this.age != null && this.age.equals(otherCat.getAge()));
        }
        return false;
    }

    @Override
    public int compareTo(Cat otherCat) {
        return name.compareTo(otherCat.getName());
    }
}

public class UsingBinarySearch {
    public static void main(String[] args) {
        searchStrings();
        searchCats();
    }

    public static void searchStrings() {
        List<String> names = Arrays.asList("John", "Martin", "Paula", "Ann");
        Collections.sort(names);
        System.out.println(names);

        System.out.println(Collections.binarySearch(names, "John"));

        System.out.println(Collections.binarySearch(names, "Laura"));
    }

    public static void searchCats() {
        Cat bella = new Cat("Bella", 5);
        Cat fluffy = new Cat("Fluffy", 1);
        List<Cat> cats = Arrays.asList(fluffy, bella);

        Collections.sort(cats);
        System.out.println(cats);

        System.out.println("Bella is at index: " + Collections.binarySearch(cats, bella));

        Comparator<Cat> byAge = (c1, c2) -> c1.getAge() - c2.getAge();
        Collections.sort(cats, byAge);
        System.out.println(cats);

        System.out.println("Bella is at index: " + Collections.binarySearch(cats, bella, byAge));
    }
}
