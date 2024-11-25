package Lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class StaticMethodReferences {
    public static void main(String[] args) {
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMr = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(2,1,5,4,9);
        sortL.accept(listOfNumbers);
        System.out.println(listOfNumbers);

        listOfNumbers = Arrays.asList(8,12,4,3,7);
        sortMr.accept(listOfNumbers);
        System.out.println(listOfNumbers);

    }
}
