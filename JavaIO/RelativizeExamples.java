package JavaIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeExamples {
    public static void main(String[] args) {
        relativePaths();
        absolutePaths();
        mixPaths();
    }

    public static void relativePaths(){
        Path p1 = Paths.get("catle.txt");
        Path p2 = Path.of("farm/horses.txt");

        System.out.println(p1.relativize(p2));
        System.out.println(p2.relativize(p1));
    }

    public static void absolutePaths(){
        Path p1 = Paths.get("C:\\catle.txt");
        Path p2 = Path.of("C:\\home\\farm\\horses.txt");

        System.out.println(p1.relativize(p2));
        System.out.println(p2.relativize(p1));
    }

    public static void mixPaths(){
        Path p1 = Paths.get("catle.txt");
        Path p2 = Path.of("C:\\home\\farm\\horses.txt");

        System.out.println(p1.relativize(p2));
        // System.out.println(p2.relativize(p1));
    }
}
