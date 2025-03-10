package JavaIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Attributes {
    public static void main(String[] args) {
        checkAttributes(Path.of("C:\\Users\\iss211\\java_updates\\JavaIO\\Attributes.java"));
        System.out.println();
        checkAttributes(Path.of("C:\\Users\\iss211\\java_updates\\JavaIO\\nio"));

    }

    public static void checkAttributes(Path path) {
        System.out.println(path);
        System.out.println("isDirectory: " + Files.isDirectory(path));
        System.out.println("isRegularFile: " + Files.isRegularFile(path));
        System.out.println("issymbolicLink: " + Files.isSymbolicLink(path));
        System.out.println("isWritable: " + Files.isWritable(path));
        System.out.println("isExecutable: " + Files.isExecutable(path));
        try {
            System.out.println("isHidden: " + Files.isHidden(path));
            System.out.println("size: " + Files.size(path));
            System.out.println("getLastModifiedTime: " + Files.getLastModifiedTime(path));

            long millisfromEpoch = Files.getLastModifiedTime(path).toMillis();
            ZonedDateTime zdt = FileTime.fromMillis(millisfromEpoch).toInstant().atZone(ZoneId.of("Europe/Dublin"));
            System.out.println(zdt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
