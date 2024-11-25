package Lambdas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {
    String name = "";

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("John");

        int x = 12; // final or effectively final
                    

        //Lambdas take a snapshot of locl variables; these local variables must not change.
        Predicate<String> lambda = s -> {
            new LambdaEffectivelyFinal().name = "Knnedy";
            System.out.println("x == " + x);
            return s.isEmpty() && x % 2 == 0;
        };

        filterData(al, lambda);
        System.out.println(al);

        new LambdaEffectivelyFinal().name = "Sean";

        filterData(al, lambda);
    }

    public static void filterData(List<String> list, Predicate<String> lambda) {
        Iterator<String> i = list.iterator();

        while (i.hasNext()) {
            if (lambda.test(i.next())) {
                i.remove();
            }
        }
    }
}
