package Collections;

interface Moveable<T> {
    void move(T t);

}

class MoveFeline implements Moveable<Cat> {
    @Override
    public void move(Cat cat) {
        System.out.println("Moving a cat");
    }
}

class MoveDog implements Moveable<Dog> {
    @Override
    public void move(Dog dog) {
        System.out.println("Moving a dog");
    }
}

class SomeMoveable<U> implements Moveable<U> {
    @Override
    public void move(U u) {
    }

}

public class GenericInterface {
    public static void main(String[] args) {
        new MoveFeline().move(new Cat());
        // new MoveFeline().move(new Dog());//The method move(Cat) in the type
        // MoveFeline is not applicable for the arguments (Dog)
        new MoveDog().move(new Dog());
        // new MoveDog().move(new Cat()); //The method move(Dog) in the type MoveDog is
        // not applicable for the arguments (Cat)

        new SomeMoveable<Cat>().move(new Cat());
        new SomeMoveable<Dog>().move(new Dog());
    }
}
