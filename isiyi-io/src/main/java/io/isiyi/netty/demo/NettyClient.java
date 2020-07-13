package io.isiyi.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName ChatClient
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/28 16:03
 * @Version 1.0
 */
public class NettyClient {


    public static void main(String[] args) throws Exception {
        //创建一个线程组
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();


        //创建客户端的启动助手，完成相关的配置
        Bootstrap  bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>(){
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new NettyClientHandler());
                    }
                });
        System.out.println("客户端已经就绪");

        //客户端连接服务端
        ChannelFuture future = bootstrap.connect("127.0.0.1", 9999).sync();

        //关闭通道（异步非阻塞）
        future.channel().closeFuture().sync();






    }

}
