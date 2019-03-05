package com.cjt.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.nio.Buffer;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-02-17 22:04
 */
public class ByteBufTest {

  /**
   * 78
   * @param args
   */
  public static void main(String[] args) {

    ByteBuf byteBuf = Unpooled.buffer(10);

    for (int i = 0; i < 10; i++) {
      byteBuf.writeByte(i);
    }

    for (int i = 0; i < byteBuf.capacity(); i++) {
      //绝对方法 和 相对方法
      //System.out.println(byteBuf.getByte(i));
      System.out.println(byteBuf.readByte());
    }

  }



}
