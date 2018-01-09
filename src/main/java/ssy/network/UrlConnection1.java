package ssy.network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnection1 {

    public static void main(String[] args) throws  Exception {

        URL url = new URL("http://www.qq.com");

//        URLConnection conn = url.openConnection();
//        InputStream is = conn.getInputStream();

        InputStream is = url.openStream();

        OutputStream os = new FileOutputStream("c:\\qq.html");

        byte[] buffer = new byte[2048];

        int length = 0;
        while ((length = is.read(buffer, 0, buffer.length)) != -1) {
            os.write(buffer, 0, length);
        }

        is.close();
        os.close();


    }
}
