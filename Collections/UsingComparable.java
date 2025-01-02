package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Product implements Comparable<Product> {
    private Integer id;

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product[id=" + id + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            return this.id.equals(((Product) obj).getId());
        }
        return false;
    }

    @Override
    public int compareTo(Product product) {
        return id.compareTo(product.id);
        // return Integer.compare(id, product.id);
        // return id-product.id; //sorts ascending by id
    }

}

class Dog implements Comparable<Dog> {
    private String name;
    private Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog[name=" + name + ",age=" + age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dog) {
            return this.name.equals(((Dog) obj).getName()) && this.age.equals(((Dog) obj).getAge());
        }
        return false;
    }

    @Override
    public int compareTo(Dog otherDog) {
        return name.compareTo(otherDog.getName());
    }

}

class Cat {
    private String name;
    private Integer age;

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat[name=" + name + ",age=" + age + "]";
    }

}

class Worker {
    private Integer id;

    Worker(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Worker[id=" + id + "]";
    }
}

class Boss implements Comparable<Boss> {
    private Integer id;

    public Boss(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Boss[id=" + id + "]";
    }

    @Override
    public int compareTo(Boss boss) {
        return this.id - boss.getId();
    }

}

public class UsingComparable {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(99));
        products.add(new Product(9));
        products.add(new Product(19));
        Collections.sort(products);
        System.out.println(products);

        comparable(new Dog[] { new Dog("Spot", 2), new Dog("Rover", 7) });
        comparable(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));

        comparator(new Dog[] { new Dog("Spot", 2), new Dog("Rover", 7) });
        comparator(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Whiskers", 5));
        cats.add(new Cat("Bella", 7));
        cats.add(new Cat("Bella", 2));

        Comparator<Cat> compCat = Comparator.comparing(Cat::getName).thenComparingInt(Cat::getAge);

        Collections.sort(cats, compCat);
        System.out.println(cats);

        treeSetComparator();

    }

    public static void comparable(Dog[] dogArray) {
        Arrays.sort(dogArray);
        System.out.println(Arrays.toString(dogArray));
    }

    public static void comparable(List<Dog> dogList) {
        Collections.sort(dogList);
        System.out.println(dogList);
    }

    public static void comparator(Dog[] dogArray) {
        Comparator<Dog> byAge = Comparator.comparing(dog -> dog.getAge());
        Arrays.sort(dogArray, byAge);
        System.out.println(Arrays.toString(dogArray));

        Comparator<Dog> byAgeReversed = Comparator.comparing(Dog::getAge).reversed();
        Arrays.sort(dogArray, byAgeReversed);
        System.out.println(Arrays.toString(dogArray));
    }

    public static void comparator(List<Dog> dogList) {
        Comparator<Dog> byAge = Comparator.comparing(dog -> dog.getAge());
        Collections.sort(dogList, byAge);
        System.out.println(dogList);

        Comparator<Dog> byAgeReversed = Comparator.comparing(Dog::getAge).reversed();
        Collections.sort(dogList, byAgeReversed);
        System.out.println(dogList);
    }

    public static void treeSetComparator() {
        Set<Boss> bosses = new TreeSet<>();
        bosses.add(new Boss(20));
        bosses.add(new Boss(10));
        bosses.add(new Boss(15));
        System.out.println(bosses);

        // Set<Worker> workers = new TreeSet<>();//Exception in thread "main"
        // java.lang.ClassCastException: class Collections.Worker cannot be cast to
        // class java.lang.Comparable
        // Set<Worker> workers = new TreeSet<>((w1, w2) -> w1.getId() - w2.getId());
        // Set<Worker> workers = new TreeSet<>(Comparator.comparing(w -> w.getId()));
        Set<Worker> workers = new TreeSet<>(Comparator.comparing(Worker::getId));
        workers.add(new Worker(20));
        workers.add(new Worker(10));
        workers.add(new Worker(15));
        System.out.println(workers);
    }

}
