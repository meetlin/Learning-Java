package cn.echohce.io;

import java.io.File;

/**
 * Created by lin on 2016/4/28.
 */
public class fileTest {
    public static void main(String[] args) {
        File d = new File("E:\\For Java");
        File [] list = d.listFiles();
        int fcount = 0, dcount = 0;// 文件和目录计数器
        System.out.println(d.toString() + "目录下的文件:");
        for (int i = 0;i < list.length;++i)
        {
            if (list[i].isFile())
            {
                System.out.println(list[i].getName());
                fcount++;
            }
        }

        System.out.println(d.toString() + "目录下的目录：");
        for (int i = 0;i<list.length;i++)
        {
            if (list[i].isDirectory()){
                System.out.println(list[i].getName());
                dcount++;
            }
        }
        System.out.println(d.toString() + "目录下的文件总数为"+ fcount);
        System.out.println(d.toString() + "目录下的文件总数为"+ dcount);

    }
}
