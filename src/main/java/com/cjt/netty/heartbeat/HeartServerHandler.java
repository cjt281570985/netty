package com.cjt.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-04-11 1:32
 */
public class HeartServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

    if (evt instanceof IdleStateEvent) {
      String eventType = "";
      IdleStateEvent e = (IdleStateEvent) evt;
      if (e.state() == IdleState.READER_IDLE) {
        eventType = "读空闲了";
      } else if (e.state() == IdleState.WRITER_IDLE) {
        eventType = "写空闲了";

      } else if (e.state() == IdleState.ALL_IDLE) {
        eventType = "读写空闲了........";
      }
      System.out.println(ctx.channel().remoteAddress() +" --> " + eventType);
      ctx.channel().close();
    }

  }
}
