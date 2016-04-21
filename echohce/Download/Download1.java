package cn.echohce.Download;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lin on 2016/4/16.
 */
public class Download1 {
    // 资源文件URL
    private static String path = "http://localhost:8080/CustomeView04.rar";
    // 文件名
    private static String fileName = "CustomeView04.rar";
    // 线程数
    public static int threadNum = 3;
    public static void main(String[] args) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200)
        {
            // 获取文件长度
            int length = conn.getContentLength();
            System.out.println("长度为: " + length );
            // 创建临时文件
            // "rwd"   打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底
            RandomAccessFile raf = new RandomAccessFile("CustomeView04.rar","rwd");
            //指定创建的这个文件的长度
            raf.setLength(length);
            raf.close();
            // 求出每一块需要下载的量
            int blockSize = length / threadNum;
            for (int i = 0 ;i< threadNum;i++)
            {
                // 开始下载的位置
                int startPos = i * blockSize;
                // 最后下载的位置
                int endPos = (i+1) * blockSize -1;
                if (i == threadNum-1)
                {
                    // 当判断为最后一个线程时候，我们需要把全部都要下完，可能会大过之前的长度
                    endPos = length;
                }
                System.out.println("线程: " + i + " 下载 " + startPos+"->" +endPos);
                // 开启线程
                new DownloadThread(path,startPos,endPos,i).start();

            }
        }


    }

    private static class DownloadThread extends Thread{
        private String path;
        private int startPos;
        private int endPos;
        private int threadId;

        /**
         * @param path URL地址
         * @param startPos 线程开始的位置
         * @param endPos 线程下载结束的位置
         * @param i  线程ID
         */
        public DownloadThread(String path, int startPos, int endPos, int i) {
            this.path = path;
            this.startPos = startPos;
            this.endPos = endPos;
            this.threadId = i;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setRequestMethod("GET");
                // 本代码的重点，我们可以向服务器指定下载文件的位置，所以可以多线程下载
                conn.setRequestProperty("Range","bytes="+startPos+"-"+endPos);
                RandomAccessFile raf = new RandomAccessFile("CustomeView04.rar","rwd");

                // 创建1024大小的字节数组作为缓冲区 也就是1K
                byte [] buffer =  new byte[1024];
                // 将raf指到相应的位置
                raf.seek(startPos);
                // 打印请求码
                System.out.println(conn.getResponseCode());

                InputStream is = conn.getInputStream();
                int len = 0;
                while ((len = is.read(buffer))!=-1){
                    raf.write(buffer,0,len);
                }
                raf.close();
                is.close();
                System.out.println("线程:" + threadId + "下载完毕");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
