package ssy.io2;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReader1 {

    public static void main(String[] args) throws  Exception{

        FileReader fr = new FileReader("E:\\gitSpace\\netty\\src\\main\\java\\ssy\\io2\\FileReader1.java");

        BufferedReader bf = new BufferedReader(fr);
        String str = bf.readLine();
        while (str != null) {
            System.out.println(str);
            str = bf.readLine();
        }

    }
}
