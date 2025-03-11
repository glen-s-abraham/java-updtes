package LVTI;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableTypeInference {
    public static void main(String[] args) {
        var x = 2;
        var y = 3.2;
        var t = "abc";

        List<String> ls = new ArrayList<>();
        ls.add("a");
        ls.add("a");
        ls.add("b");
        ls.removeIf((var s)->s.equals("a"));
        System.out.println(ls);
    }
}
