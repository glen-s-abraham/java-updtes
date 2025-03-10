package JavaIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchDirectory {
    public static void main(String[] args) {
        Path startPath = Paths.get("C:\\Users\\iss211\\java_updates\\JavaIO");
        try (var streamPaths = Files.find(startPath, 10,
                (path, attr) -> attr.isRegularFile() && path.toString().endsWith(".java"))) {
            streamPaths.forEach(System.out::println);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
