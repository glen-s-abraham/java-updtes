package Lambdas;
import java.util.function.Predicate;

public class TestEvaluate {

    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate: " + lambda.isNegartive(-1));
        System.out.println("Evaluate: " + lambda.isNegartive(+1));

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));
        System.out.println("Predicate: " + predicate.test(+1));

        int x = 4;
        System.out.println("Is " + x + " Even? " + check(x, n -> n % 2 == 0));
        x = 7;
        System.out.println("Is " + x + " Even? " + check(x, n -> n % 2 == 0));

        String name = "Mr. Joe Bloggs";
        System.out.println("Does name" + " " + name + "starts with Mr. " + " " + check(name, s -> s.startsWith("Mr.")));
        name = "Ms. Ann Frank";
        System.out.println("Does name" + " " + name + "starts with Mr. " + " " + check(name, s -> s.startsWith("Mr.")));

    }

    public static <T> Boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}
