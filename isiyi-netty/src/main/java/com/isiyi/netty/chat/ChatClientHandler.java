package com.isiyi.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: ChatClientHandler
 * @author: 向鹏飞
 * @since: 2021/5/5
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
