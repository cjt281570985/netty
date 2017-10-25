package ssy.io2;

import java.io.*;

public class StreamTest {


    public static void main(String[] args) throws  Exception {

        FileOutputStream fos = new FileOutputStream("k.txt");

        OutputStreamWriter osw = new OutputStreamWriter(fos);

        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("www.abc.com");
        bw.write("\n");
        bw.write("kkk");
        bw.close();

        FileInputStream fis = new FileInputStream("k.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String str = br.readLine();
        while (str != null) {
            System.out.println(str);
            str = br.readLine();
        }

    }
}
