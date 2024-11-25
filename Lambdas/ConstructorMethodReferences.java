package Lambdas;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorMethodReferences {
    public static void main(String[] args) {
        Supplier<StringBuilder> sbL = ()->new StringBuilder();
        Supplier<StringBuilder> sbMr = StringBuilder::new;

        StringBuilder sb1 = sbL.get();sb1.append("lambda version");
        StringBuilder sb2 = sbMr.get();sb1.append("method reference version");

        Function<Integer, List<String>> alL = x-> new ArrayList<>(x);
        Function<Integer, List<String>> alMr = ArrayList::new;

        List<String> ls1 = alL.apply(10);
        ls1.add("21");
        System.out.println(ls1);

        List<String> ls2 = alMr.apply(10);
        ls2.add("88");
        System.out.println(ls2);
        
    }
}
