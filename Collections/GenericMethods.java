package Collections;

public class GenericMethods {
    public static <T> void genericMethod(T t) {
        MyGenerics<T> myGen = new MyGenerics<>(t);
        System.out.println(myGen.getT());
    }

    public static <T, U, V> void register(T t, U u, V v) {
        Register<T, U, V> register = new Register(t, u, v);
        System.out.println(register.getName() + " " + register.getAge());
    }

    public static <T> MyGenerics<T> createGeneric(T t) {
        return new MyGenerics<>(t);
    }

    public static void main(String[] args) {
        genericMethod("SK");
        genericMethod(1.1);

        register(new Dog(), "Sheep", 3);
        register(new Cat(), "Whiskers", 2);

        MyGenerics<Integer> myGen = createGeneric(4);
        System.out.println(myGen.getT());
    }
}
