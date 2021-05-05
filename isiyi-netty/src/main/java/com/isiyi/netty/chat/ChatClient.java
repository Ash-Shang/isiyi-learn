package com.isiyi.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * 聊天客户端
 * <p></p>
 *
 * @version 1.0.0
 * @description: ChatClient
 * @author: 向鹏飞
 * @since: 2021/5/5
 */
public class ChatClient {
    private String host;
    private int port;
    public ChatClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void run(){

        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(nioEventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("StringDecoder", new StringDecoder())
                                    .addLast("StringEncoder", new StringEncoder())
                                    .addLast("ChatClientHandler", new ChatClientHandler());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            Channel channel = channelFuture.channel();
            System.out.println("客户端上线了-------"+channel.remoteAddress());
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                channel.writeAndFlush(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            nioEventLoopGroup.shutdownGracefully();
        }
    }

    public static void client(){
        ChatClient chatClient = new ChatClient("127.0.0.1", 7788);
        chatClient.run();
    }


}
