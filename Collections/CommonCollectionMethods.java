package Collections;

import java.util.ArrayList;
import java.util.Collection;

class CommonCollectionMethods{
    public static void main(String[] args) {
        // Creating a list
        Collection<String> col1 = new ArrayList<>();
        col1.add("Apple");
        col1.add("Lucy");
        col1.add("Apple");
        
        System.out.println(col1);
        System.out.println(col1.remove("Apple"));
        System.out.println(col1);
        System.out.println(col1.isEmpty());
        System.out.println(col1.size());
        System.out.println(col1.contains("John"));
        System.out.println(col1.contains("Apple"));
        //predicate
        System.out.println(col1.removeIf(x -> x.startsWith("L")));
        col1.forEach(System.out::println);
        col1.clear();
        col1.forEach(System.out::println);


    }
}