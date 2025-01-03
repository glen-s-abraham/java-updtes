package Collections;

class MyGenerics<T> {
    T instance;

    public MyGenerics(T instance) {
        this.instance = instance;
    }

    public T getT() {
        return instance;
    }
}

public class TestGenericClass {
    public static void main(String[] args) {
        MyGenerics<String> g = new MyGenerics<>("SK");
        System.out.println(g.getT()); // prints: SK

        MyGenerics<Integer> g2 = new MyGenerics<>(1);
        System.out.println(g2.getT()); // prints: SK
    }
}
