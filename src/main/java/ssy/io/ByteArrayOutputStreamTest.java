package ssy.io;

import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamTest {


    public static void main(String[] args) throws Exception {

        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String str = "cjt yzy kkk";
        byte[] bytes = str.getBytes();

        f.write(bytes);

        //创建一个新分配的字节数组。 其大小是此输出流的当前大小，缓冲区的有效内容已被复制到其中
        byte[] result = f.toByteArray();

        for (int i = 0; i < result.length ; i++) {
            System.out.print((char)result[i]);
        }
    }
}
