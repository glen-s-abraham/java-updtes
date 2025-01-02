package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class UsingLists {
    public static void main(String[] args) {

        // Factory methods
        factorymethods();

        //Array list
        arrayList();

        //Stack
        stack();

        //Linked List
        linkedList();

    }

    public static void factorymethods() {
        String[] array = new String[] { "Alpha", "Beta", "Charlie" };
        List<String> aslist = Arrays.asList(array);
        List<String> of = List.of(array);
        List<String> copy = List.copyOf(aslist);

        array[0] = "Delta";
        System.out.println(Arrays.toString(array));
        System.out.println(aslist);

        aslist.set(1, "Echo");
        System.out.println(Arrays.toString(array));
        System.out.println(aslist);
    }

    public static void arrayList() {
        List<String> list = new ArrayList<>();

        list.add("Alan");
        list.add("Alan");
        list.add("Sean");
        list.add("Mary");
        list.add("Mary");

        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(0);
        list.remove("Mary");
        System.out.println(list);
        list.set(0, "Jack");

        list.replaceAll(name -> name + " Kennedy");
        System.out.println(list);

    }

    public static void stack() {
        Stack<String> stack = new Stack<>();
        stack.push("Alpha");
        stack.push("Beta");
        stack.push("Charlie");
        System.out.println(stack);
        System.out.println("Top: "+stack.peek());
        System.out.println("Poped: "+stack.pop());
        stack.push("Helen");
        System.out.println(stack);
    }

    public static void linkedList() {
        LinkedList<String> names = new LinkedList<>();
        names.add("Alan");
        names.add("Sean");
        names.addFirst("Brian");
        names.addLast("Edward");

        System.out.println(names);

        names.remove("David");
        names.removeFirst();
        names.removeLast();
        System.out.println(names);
    }
}
