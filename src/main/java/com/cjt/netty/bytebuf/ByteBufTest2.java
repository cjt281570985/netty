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
   *
   * @param args
   */
  public static void main(String[] args) {

    //composite buffer (可认为是一个容器或一个列表可容纳heap buffer或direct buffer)   此种是 java没提供
    CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer(); //返回一个没有组件的新big-endian复合缓冲区

    ByteBuf heapBuf = Unpooled.buffer(10);
    ByteBuf directBuf = Unpooled.directBuffer(8);

    compositeByteBuf.addComponents(heapBuf, directBuf);
    compositeByteBuf.removeComponent(0);

    Iterator<ByteBuf> it = compositeByteBuf.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    compositeByteBuf.forEach(System.out::println);

  }



}
