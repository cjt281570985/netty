package ssy.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ByteArrayInputStreamTest {


    public static void main(String[] args) throws Exception {

        String temp = "cjt";

        byte[] bytes = temp.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        for (int i = 0; i < temp.length() ; i++) {

            int c;
            while (-1 != (c=in.read())){
                if (0 == i) {
                    System.out.println(( char ) c);
                } else {
                    System.out.println(Character.toUpperCase((char)c));
                }
            }

            System.out.println();
            in.reset(); //将此流重新定位到上次在此输入流上调用 mark方法时的位置
        }
    }
}
