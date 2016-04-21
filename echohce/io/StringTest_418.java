package cn.echohce.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by lin on 2016/4/18.
 */
public class StringTest_418 {
    public static void main(String[] args) {
        // read();
        // testBufferReader();
        Scanner s1 = new Scanner(System.in);
        // 用于区分next()与nextLine()的区别
//        System.out.println("next( )方法输入字符串");
        String s2 = s1.nextLine();
        System.out.println("得到的字符串:" + s2 + "长度为:" + s2.length());
        System.out.println("nextLine( )方法输入字符串");
        int s = s1.nextInt();
        System.out.println("得到的字符串:" + s);
    }

    public static void testScanner() {
        Scanner s1 = new Scanner(System.in);
        // 用于区分next()与nextLine()的区别
        System.out.println("next( )方法输入字符串");
        String s2 = s1.next();
        System.out.println("得到的字符串:" + s2 + "长度为:" + s2.length());
        System.out.println("nextLine( )方法输入字符串");
        int s = s1.nextInt();
        System.out.println("得到的字符串:" + s);

    }

    private static void read() {
        char c;
        try {
            c = (char) System.in.read();
            System.out.println("键盘输入的字符为:" + c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testBufferReader() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("输入一串字符：");
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("打印输出的字符:\n" + str);
    }
}
