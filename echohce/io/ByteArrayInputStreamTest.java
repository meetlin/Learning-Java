package cn.echohce.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lin on 2016/4/18.
 */
public class ByteArrayInputStreamTest {
    public static void main(String[] args) throws Exception {
        System.out.println(getHtml("https://www.baidu.com"));
    }

    public static String getHtml(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200) {
            InputStream in = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            in.close();
            byte [] data = out.toByteArray();
            System.out.println(out.toString("UTF-8"));
            String html = new String(data,"UTF-8");
            return html;
        }
        return null;
    }
}
