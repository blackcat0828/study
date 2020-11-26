package study;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class classPathTest {
    public static void main(String[] args) throws IOException {
//        String resource = "D:\\study\\study\\Java\\day1126\\src\\study\\";
        String resource = "./src/study/";
        Path path = Paths.get(resource+"bank-data-simple.csv");
        List<String> lines = Files.readAllLines(path);
        for(String a : lines){
            System.out.println(a);
        }


    }
}
