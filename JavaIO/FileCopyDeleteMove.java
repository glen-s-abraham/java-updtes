package JavaIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyDeleteMove {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Users\\iss211\\java_updates\\JavaIO\\nio\\src.txt");
        Path target = Paths.get("C:\\Users\\iss211\\java_updates\\JavaIO\\nio\\target.txt");
        Path target2 = Paths.get("C:\\Users\\iss211\\java_updates\\JavaIO\\nio\\target2.txt");

        Files.createDirectories(Paths.get("C:\\Users\\iss211\\java_updates\\JavaIO\\nio"));
        if (Files.exists(source)) {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        } else {
            Files.createFile(source);
            Files.copy(source, target);
            Files.move(source, target2);
            Files.delete(target2);
        }
    }
}
