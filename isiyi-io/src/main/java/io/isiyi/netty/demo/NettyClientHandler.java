package io.isiyi.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 客户端业务处理类
 * @Author Ash-Shang
 * @Date 2020/3/28 16:04
 * @Version 1.0
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client:"+ ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("老板还钱吧！", CharsetUtil.UTF_8));
    }


    /**
     * 读数据事件
     * @author: Ash-Shang
     *  @Date: 2020/3/28 16:33
     *  @Description:
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;

        System.out.println("服务端发来了信息:"+byteBuf.toString(CharsetUtil.UTF_8));
    }
}
