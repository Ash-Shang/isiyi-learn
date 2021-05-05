package com.isiyi.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: HeartBeatServerHandler
 * @author: 向鹏飞
 * @since: 2021/5/5
 */
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //判断事件是否是IdleStateEvent 类型
        if(evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            String evenType = "";
            switch (idleStateEvent.state()){
                case ALL_IDLE:
                    evenType = "读写空闲。。。";
                    break;
                case READER_IDLE:
                    evenType = "读空闲。。。。";
                    break;
                case WRITER_IDLE:
                    evenType = "写空闲。。。。";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() +"空闲。。。"+evenType);
            System.out.println("服务器 do something....");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
