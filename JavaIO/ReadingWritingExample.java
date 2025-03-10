package JavaIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadingWritingExample {
    public static void main(String[] args) {
        // copyTextFile(false);
        copyTextFile(true);
        // copyBinaryFile(false);
        copyBinaryFile(true);
    }

    public static void copyTextFile(boolean buffering) {
        File src = new File("C:\\Users\\iss211\\java_updates\\JavaIO\\src.txt");
        File dest = new File("C:\\Users\\iss211\\java_updates\\JavaIO\\dest.txt");

        try (var rdr = new BufferedReader(new FileReader(src))) {
            var wrtr = new BufferedWriter(new FileWriter(dest));
            if (buffering) {
                String str = null;

                while ((str = rdr.readLine()) != null) {
                    System.out.println(str);
                    wrtr.write(str);
                    wrtr.newLine();
                }
            } else {
                int b;
                while ((b = rdr.read()) != -1) {
                    System.out.println(b);
                    wrtr.write(b);
                }
            }
            wrtr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void copyBinaryFile(Boolean buffering) {
        File src = new File("C:\\Users\\iss211\\java_updates\\JavaIO\\ReadingWritingExample.class");
        File dest = new File("C:\\Users\\iss211\\java_updates\\JavaIO\\dest.class");
        try (var in = new BufferedInputStream(new FileInputStream(src))) {
            var out = new BufferedOutputStream(new FileOutputStream(dest));
            if (buffering) {
                var buffer = new byte[1024];
                int nnumbytesRead = 0;
                while ((nnumbytesRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, nnumbytesRead);
                    out.flush();
                }
            } else {
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
