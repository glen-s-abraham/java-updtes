package JavaIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class AttributesView {
    public static void main(String[] args) throws IOException {
        var path = Path.of("C:\\Users\\iss211\\java_updates\\JavaIO\\Attributes.java");
        System.out.println(path);
        BasicFileAttributes view = Files.readAttributes(path,BasicFileAttributes.class);
        System.out.println("isDirectory: "+view.isDirectory());
        System.out.println("isRegularFile: "+view.isRegularFile());
        System.out.println("isSymbolicLink: "+view.isSymbolicLink());
        System.out.println("size: "+view.size());
        System.out.println("lastModifiedTime: "+view.lastModifiedTime());

        BasicFileAttributeView updview = Files.getFileAttributeView(path,BasicFileAttributeView.class);
        BasicFileAttributes attrs = updview.readAttributes();
        final long THIRTY_MIN_MSEC = 100 * 60 * 30;
        FileTime lastModifiedTime = FileTime.fromMillis(attrs.lastModifiedTime().toMillis()+THIRTY_MIN_MSEC);
        updview.setTimes(lastModifiedTime, null, null);
        view = Files.readAttributes(path,BasicFileAttributes.class);
        System.out.println("lastModifiedTime: "+view.lastModifiedTime());
    }
}
