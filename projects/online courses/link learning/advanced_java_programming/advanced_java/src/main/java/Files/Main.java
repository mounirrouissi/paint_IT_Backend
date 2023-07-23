package Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/thinkpad t490/Documents/projects/online courses/link learning/advanced_java_programming/advanced_java/data.txt"));
            reader.lines().forEach(System.out::println);
            Path path = Paths.get("C:/Users/thinkpad t490/Documents/projects/online courses/link learning/advanced_java_programming/advanced_javas");
            if(Files.exists(path))
            try {
                Files.list(path).forEach(System.out::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            else{
                System.out.println("notfound");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
