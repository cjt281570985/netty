package ssy.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BufferedOutPutStreamTest1 {


    public static void main(String[] args) throws Exception {

        OutputStream os = new FileOutputStream("yzy.txt");
        //将os包装成具有对文件的输出,同时有缓冲的功能
        BufferedOutputStream bos = new BufferedOutputStream(os);
        bos.write("http://www.baidu.com".getBytes());
        //不调用close则无法写入数据
        //该close的方法FilterOutputStream调用其flush方法，然后调用close其基础输出流的方法
        bos.close();
    }
}
