package JavaIO;

import java.nio.file.Path;

public class NormalizeExamples {
    public static void main(String[] args) {
        Path p1 = Path.of("./x/y/../sean.txt");
        System.out.println(p1.normalize());

        Path p2 = Path.of("./x/y/../z");
        System.out.println(p1.normalize());

        Path p3 = Path.of(".\\a");
        System.out.println(p1.normalize());

        Path p4 = Path.of("../x/y");
        System.out.println(p1.normalize());

        Path p5 = Path.of("/a/b/../../x.y");
        Path p6 = Path.of("./x.y");
        System.out.println(p5.normalize());
        System.out.println(p6.normalize());
        System.out.println(p5.equals(p6));
        System.out.println(p5.normalize().equals(p6.normalize()));
    }
}
