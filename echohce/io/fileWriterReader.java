package cn.echohce.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lin on 2016/4/28.
 */
public class fileWriterReader {
    public static void main(String[] args) {
        File f = new File("d:\\lin.txt");
        char[] b = "nihaoya你好呀".toCharArray();
        try {
            FileWriter out = new FileWriter(f);
            FileReader reader = new FileReader(f);
            out.write(b);
            out.close();
            int i = 0;
            while ((i = reader.read(b, 0, 2)) != -1) {
                System.out.println(new String(b, 0, i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
