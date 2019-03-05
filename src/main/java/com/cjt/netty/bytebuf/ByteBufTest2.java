package com.cjt.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-02-25 01:01
 */
public class ByteBufTest2 {

  /**
   * 79
   * @param args
   */
  public static void main(String[] args) {

    CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

    ByteBuf heapBuf = Unpooled.buffer(10);
    ByteBuf directBuf = Unpooled.directBuffer(8);

    compositeByteBuf.addComponents(heapBuf, directBuf);

    Iterator<ByteBuf> it = compositeByteBuf.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    compositeByteBuf.forEach(System.out::println);

  }



}
