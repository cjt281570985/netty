package ssy.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutPutStreamTest {


    public static void main(String[] args) throws Exception {

        OutputStream os = new FileOutputStream("c:/src/v.txt", true);
        String s = " addshello af";
        os.write(s.getBytes());
        os.close();


    }
}
