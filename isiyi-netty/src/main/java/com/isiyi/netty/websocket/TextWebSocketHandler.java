package com.isiyi.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * 文本帧处理 handler
 * <p></p>
 *
 * @version 1.0.0
 * @description: 文本帧处理 handler
 * @author: 向鹏飞
 * @since: 2021/5/5
 */
public class TextWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("收到消息：" + msg.text());
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间：" + LocalDateTime.now() + ","+ msg.text()));
    }

    /**
     * web 连接就会触发该事件
     * <p></p>
     *
     * @param
     * @return
     * @author 向鹏飞
     * @version 1.0.0
     * @date 2021/5/5 15:32
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        String s = ctx.channel().id().asLongText();
        System.out.println("handlerAdded被调用：" + s);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        String s = ctx.channel().id().asLongText();
        System.out.println("handlerRemoved被调用：" + s);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
