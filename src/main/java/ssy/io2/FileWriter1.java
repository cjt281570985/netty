package ssy.io2;

import java.io.FileWriter;

public class FileWriter1 {


    public static void main(String[] args) throws Exception{

        String str = "hello zz world cjt yzy zlf";

        char[] buffer = new char[str.length()];

        str.getChars(0, str.length(), buffer, 0);

        FileWriter f = new FileWriter("file2.txt");

        f.write(buffer);

        f.close();

    }
}
