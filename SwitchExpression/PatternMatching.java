package SwitchExpression;

public class PatternMatching {
    public static void whatType(Object o) {
        switch (o) {
            case String s -> System.out.println("String");
            case Integer i -> System.out.println("Integer");
            case null -> System.out.println("Null");
            default -> System.out.println("Not Recognised");
        }
    }

    public static void infoOnType(Object o) {
        switch (o) {
            case String s when s.startsWith("A") ->
                System.out.println("String beginning with A: " + s);
            case Integer i when i.intValue() > 10 ->
                System.out.println("Integer > 10: " + i);
            default ->
                System.out.println("Not recognised");
        }
    }

    public static void main(String[] args) {
        whatType("ABC");
        whatType(122);
        whatType(null);
        whatType(22.29);

        infoOnType("ABC");
        infoOnType("abc");
        infoOnType(12);
        infoOnType(8);
    }
}
