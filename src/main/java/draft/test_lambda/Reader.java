package draft.test_lambda;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("D:\\test1.txt"), StandardCharsets.UTF_8)
                .forEach(Reader::addId);
    }

    public static void addId(String str){
        System.out.println(str);
        try {
            if(str.equals("@id")) {
                PrintWriter out = new PrintWriter(new FileWriter(new File("D:\\output.txt"), true));
                out.append(str);
                out.append("\r\n");
                out.append("Нужные строчки");
                out.append("\r\n");
                out.close();
            }else{
                PrintWriter out = new PrintWriter(new FileWriter(new File("D:\\output.txt"), true));
                out.append(str);
                out.append("\r\n");
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
