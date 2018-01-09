package com.cjt.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NioTest13 {


        public static void main(String[] args) throws Exception {

            String inputFile = "Niotest13_in.txt";
            String outPutFile = "Niotest13_out.txt";

            RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
            RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outPutFile, "rw");

            long inputLength = new File(inputFile).length();

            FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
            FileChannel outputFileChannel = outputRandomAccessFile.getChannel();

            Charset.availableCharsets().forEach((k,v)->{
                System.out.println(k + ", " + v);
            });

            //通过内存映射文件,把整个文件伍映射上,修改内存里面的内容直接反应到文件上
            MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);

            Charset charset = Charset.forName("iso-8859-1");
            CharsetDecoder decoder = charset.newDecoder();
            CharsetEncoder encoder = charset.newEncoder();

            CharBuffer charBuffer = decoder.decode(inputData);
            ByteBuffer outBuffer = encoder.encode(charBuffer);

            outputFileChannel.write(outBuffer);

            inputFileChannel.close();
            inputFileChannel.close();

        }

}
