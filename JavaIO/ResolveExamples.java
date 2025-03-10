package JavaIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveExamples {
    public static void main(String[] args) {
        Path absolute = Paths.get("C:\\Users\\iss211\\java_updates\\JavaIO");
        Path relative = Path.of("nio");
        Path file = Path.of("name.txt");

        System.out.println("absolute.resolve(relative): "+absolute.resolve(relative));
        System.out.println("absolute.resolve(file): "+absolute.resolve(file));
        System.out.println("relative.resolve(file): "+relative.resolve(file));

        //trying to resolve and absolute path within anything just returns the absolute path
        System.out.println("relative.resolve(absolute): "+relative.resolve(absolute));
        System.out.println("file.resolve(absolute): "+file.resolve(absolute)); 
        System.out.println("absolute.resolve(absolute): "+absolute.resolve(absolute));

        

    }
}
