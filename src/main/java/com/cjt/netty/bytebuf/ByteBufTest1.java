package com.cjt.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-02-25 00:40
 */
public class ByteBufTest1 {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {

    ByteBuf byteBuf = Unpooled.copiedBuffer("吉hello world", CharsetUtil.UTF_8);

    //如果buf背后是用字节数组来存放的
    if (byteBuf.hasArray()) { //为true 则  为堆上缓冲,用字节数组来存放的
      byte[] content = byteBuf.array();
      System.out.println(new String(content, Charset.forName("utf-8")));

      System.out.println(byteBuf);
      System.out.println(byteBuf.arrayOffset()); // 0
      System.out.println(byteBuf.readerIndex()); // 0
      System.out.println(byteBuf.writerIndex()); // 11
      System.out.println(byteBuf.capacity());    // 33

      for (int i = 0; i < byteBuf.readableBytes(); i++) {
        System.out.print((char)byteBuf.getByte(i));
      }
      System.out.println("--------------------------------");
      System.out.println(byteBuf.getCharSequence(0,3, CharsetUtil.UTF_8)); // 吉
    }

  }



}
