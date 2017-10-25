package ssy.io;

import java.io.*;

public class DataStream1 {

    public static void main(String[] args) throws Exception{

        //我可以向文件中以缓冲的方式写入java的基本数据类型
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("data.txt")));

        byte b = 3;
        int i = 12;
        char ch = 'a';
        float f = 3.3f;

        dos.writeByte(b);
        dos.writeInt(i);
        dos.writeChar(ch);
        dos.writeFloat(f);

        dos.close();

        DataInputStream dis = new DataInputStream(new BufferedInputStream(
                new FileInputStream("data.txt")));
        System.out.println(dis.readByte());
        System.out.println(dis.readInt());
        System.out.println(dis.readChar());
        System.out.println(dis.readFloat());
    }
}
