package ssy.io2;

import java.io.CharArrayReader;

public class CharArrayReader1 {

    public static void main(String[] args) throws Exception {

        String tmp = "abcdefg";
        char[] ch = new char[tmp.length()];
        tmp.getChars(0, tmp.length(), ch, 0);

        CharArrayReader input = new CharArrayReader(ch);
        int i;
        while ((i = input.read()) != -1) {
            System.out.println((char)i);
        }

    }
}
