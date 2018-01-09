package ssy.io;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutPutStreamTest {


    public static void main(String[] args) throws Exception {

        OutputStream outputStream = new FileOutputStream("out.txt");
        String msg = "我是吉米， jimmy;";

        outputStream.write(msg.getBytes());
        outputStream.close();


    }
}
