package cn.echohce.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by lin on 2016/4/28.
 */
public class fileStream {
    public static void main(String[] args) {
        File f = new File("d:\\lin.txt");
        byte [] b = "nihaoya你好呀".getBytes();
        try {
            FileOutputStream fout = new FileOutputStream(f);
            FileInputStream fint = new FileInputStream(f);
            fout.write(b);
            fout.close();

            int i = 0;
            while((i = fint.read(b,0,2))!=-1)
            {
                System.out.println(new String(b,0,i));
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
