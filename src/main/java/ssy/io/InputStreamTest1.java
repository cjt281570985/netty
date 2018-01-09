package ssy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InputStreamTest1 {


    public static void main(String[] args) throws Exception {

        File file = new File("input.txt");

        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[200];
        int len = 0;
        String msg = "";
        while (-1 != (len = inputStream.read(bytes, 0 , 200))){
            msg = new String(bytes, 0, len);
        }

        System.out.println(msg);
        inputStream.close();

    }
}
