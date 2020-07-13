package io.isiyi.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * 服务端的业务处理类
 * @Description 服务端的业务处理类
 * @Author Ash-Shang
 * @Date 2020/3/28 16:03
 * @Version 1.0
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     *  读数据
     *  @author: Ash-Shang
     *  @Date: 2020/3/28 16:05
     *  @Description:
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("server:"+ ctx);
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端发过来的方法"+byteBuf.toString(CharsetUtil.UTF_8));
    }


    /**
     *  数据读取完毕时间
     *  @author: Ash-Shang
     *  @Date: 2020/3/28 16:05
     *  @Description:
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = Unpooled.copiedBuffer("就是没钱", CharsetUtil.UTF_8);
        ctx.writeAndFlush(byteBuf);
    }

    /**
     *  异常处理方法
     *  @author: Ash-Shang
     *  @Date: 2020/3/28 16:06
     *  @Description:
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
