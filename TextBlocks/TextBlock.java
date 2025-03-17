package TextBlocks;

public class TextBlock {
    public static void textBlocks() {
        String sName = "Sean Kennedy";
        String tbName = """
                Sean Kennedy""";

        System.out.println(sName.equals(tbName));
        System.out.println(sName == tbName);

        System.out.println(tbName.substring(5));
    }

    public static void jsonTraditional() {
        String text = "{\n" +
                "\"name\":\"Jane Doe\",\n" +
                "\"age\":23,\n" +
                "\"address\":\"Main Street, Dublin\",\n" +
                "}";
        System.out.println(text);
    }

    public static void jsonTextBlock() {
        String text = """
                {
                    "name":"Jane Doe",
                    "age":23,
                    "address": "Main street, Dublin"
                }
                """;
        System.out.println(text);
    }

    public static void main(String[] args) {
        textBlocks();
        jsonTraditional();
        jsonTextBlock();
    }

}
