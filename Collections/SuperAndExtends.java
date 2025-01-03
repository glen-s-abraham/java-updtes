package Collections;

import java.util.ArrayList;
import java.util.List;

class Animal {
}

class Dog extends Animal {
}

class Terrier extends Dog {
}

class Cat extends Animal {
}

class Manx extends Cat {
}

public class SuperAndExtends {
    public static void addAnimal(Animal[] animals) {
        animals[0] = new Dog();
        animals[1] = new Cat();// ArrayStoreException generated - JVM know the type
    }

    public static void addAnimal(List<Animal> animals) {
        animals.add(new Dog());
    }

    public static void ext(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static void spr(List<? super Cat> animals) {
        animals.add(new Cat());
        animals.add(new Manx());
        // animals.add(new Dog());//The method add(capture#4-of ? super Cat) in the type
        // List<capture#4-of ? super Cat> is not applicable for the arguments (Dog)
        for (Object o : animals) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Dog[] dogs0 = { new Dog(), new Dog() };
        // addAnimal(dogs0);

        List<Cat> cats1 = new ArrayList<>();
        List<Cat> cats2 = new ArrayList<Cat>();
        // List<Animal> animals = new ArrayList<Cat>(); //Type mismatch: cannot convert
        // from ArrayList<Cat> to List<Animal>
        // addAnimal(cats2);

        // extends
        // extends is readonly
        // extends for a class can be initialized with any of the sub classes falling
        // below it
        List<? extends Animal> animals0 = new ArrayList<Animal>();
        // animals.add(new Animal());// read only
        List<? extends Animal> animals1 = new ArrayList<Dog>();
        List<? extends Animal> animals2 = new ArrayList<Terrier>();
        List<? extends Animal> animals3 = new ArrayList<Cat>();
        List<? extends Animal> animals4 = new ArrayList<Manx>();

        // super - polyorphic assignment
        // super can be init with any super classes above the current class
        List<? super Dog> dogs1 = new ArrayList<Dog>();
        List<? super Dog> dogs2 = new ArrayList<Animal>();
        List<? super Dog> dogs3 = new ArrayList<Object>();
        // List<? super Dog> dogs4 = new ArrayList<Terrier>(); //Type mismatch: cannot
        // convert from ArrayList<Terrier> to List<? super Dog>

        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        List<Manx> manxCats = new ArrayList<>();
        manxCats.add(new Manx());
        List<Terrier> terriers = new ArrayList<>();
        terriers.add(new Terrier());

        ext(animals);
        ext(cats);
        ext(dogs);
        ext(manxCats);
        ext(terriers);
        // ext(objects);//The method ext(List<? extends Animal>) in the type
        // SuperAndExtends is not applicable for the arguments
        // (List<Object>)Java(67108979)

        spr(animals);
        spr(cats);
        spr(objects);
        // spr(dogs); //The method spr(List<? super Cat>) in the type SuperAndExtends is
        // not applicable for the arguments (List<Dog>)
        // spr(manxCats); //The method spr(List<? super Cat>) in the type
        // SuperAndExtends is not applicable for the arguments (List<Manx>)
        // spr(terriers); //The method spr(List<? super Cat>) in the type
        // SuperAndExtends is not applicable for the arguments (List<Terrier>)

    }
}
