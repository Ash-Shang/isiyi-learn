package io.isiyi.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;

            String evenType = "";
            switch (idleStateEvent.state()){
                case ALL_IDLE:
                    evenType = "读写空闲";
                    break;
                case WRITER_IDLE:
                    evenType = "写空闲";
                    break;
                case READER_IDLE:
                    evenType = "读空闲";
                    break;
                default:
                    break;
            }

            System.out.println(ctx.channel().remoteAddress() + "，事件：" + evenType);

            ctx.channel().close();
        }
    }
}
