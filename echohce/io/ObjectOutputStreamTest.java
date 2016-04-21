package cn.echohce.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by lin on 2016/4/18.
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) throws Exception{
        StudentBean student1 = new StudentBean("LinMingjian",1);
        StudentBean student2 = new StudentBean("LiGuofu",2);
        StudentBean s3,s4;
        FileOutputStream fout = new FileOutputStream("D:/student.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(student2);
        out.writeObject(student1);
        out.close();

        FileInputStream fin = new FileInputStream("D:/student.txt");
        ObjectInputStream in = new ObjectInputStream(fin);
        s3 = (StudentBean) in.readObject();
        s4 = (StudentBean) in.readObject();
        in.close();
        System.out.println(s3.getName() + " " + s3.getId());
        System.out.println(s4.getName() + " " + s4.getId());


    }
}
