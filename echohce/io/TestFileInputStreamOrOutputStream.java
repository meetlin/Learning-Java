package cn.echohce.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lin on 2016/4/18.
 */
public class TestFileInputStreamOrOutputStream {
    public static void main(String[] args) throws Exception {
        copyFile1("C:\\Users\\lin\\IdeaProjects\\Study\\src\\cn\\echohce\\io\\TestFile.txt", "C:\\Users\\lin\\IdeaProjects\\Study\\src\\cn\\echohce\\io\\TestFile1.txt");
    }

    public static void copyFile1(String file1, String file2) throws IOException {
        File file = new File(file1);
        File outfile = new File(file2);
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(outfile);
        System.out.println(inputStream.available());
        int i = 0;
        while (i != -1)

        {
            i = inputStream.read();
            outputStream.write(i);
        }
        //记得关闭流
        inputStream.close();
    }

}
