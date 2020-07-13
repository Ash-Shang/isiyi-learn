package io.isiyi.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName ChatServer
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/28 16:03
 * @Version 1.0
 */
public class NettyServer {

    public static void main(String[] args) throws Exception {
        //创建一个线程组，接受客户端连接
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        //创建一个线程组，处理网络操作
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        //创建服务端配置类
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workGroup)//设置两个线程组
                .channel(NioServerSocketChannel.class)//使用NioServerSocketChannel作为服务器端通道实现
                .option(ChannelOption.SO_BACKLOG, 128)//设置线程等待中，等待连接的数量
        .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持活跃的状态
        .childHandler(new ChannelInitializer<SocketChannel>() {//创建网络通道初始化
            //添加自定义的handler
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new NettyServerHandler());
            }
        });

        System.out.println("服务端准备完毕>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ChannelFuture future = bootstrap.bind(9999).sync();//
        System.out.println("服务器启动完毕>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");


        //关闭通道，关闭线程
        future.channel().closeFuture().sync();

        workGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }


}
