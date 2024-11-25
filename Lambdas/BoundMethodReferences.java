package Lambdas;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class BoundMethodReferences {
    public static void main(String[] args) {
        String name = "Mr. Joe Bloggs";
        Supplier<String> lowerL = ()->name.toLowerCase();
        Supplier<String> lowerMR = name::toLowerCase;

        System.out.println(lowerL.get());
        System.out.println(lowerMR.get());

        Predicate<String> titleL = title-> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;

        System.out.println(titleL.test("Mr."));
        System.out.println(titleMR.test("Mr."));


    }
}
