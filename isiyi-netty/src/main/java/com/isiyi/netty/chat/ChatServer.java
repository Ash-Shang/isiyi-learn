package com.isiyi.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * netty版群聊系统-服务端
 * <p></p>
 *
 * @version 1.0.0
 * @description: ChatServer
 * @author: 向鹏飞
 * @since: 2021/5/5
 */
public class ChatServer {
    private int port;
    public ChatServer(int port){
        this.port = port;
    }
    public void run(){
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("StringDecoder", new StringDecoder())
                                    .addLast("StringEncoder", new StringEncoder())
                                    .addLast("ChatServerHandler", new ChatServerHandler());
                        }
                    });
            System.out.println("netty 服务器配置成功。。。。");
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    public static void server(){
        ChatServer chatServer = new ChatServer(7788);
        chatServer.run();
    }
}
