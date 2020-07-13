package com.isiyi.netty.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName NIOClient
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/21 14:57
 * @Version 1.0
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {

        //得到网络通道
        SocketChannel channel = SocketChannel.open();
        //设置阻塞方式
        channel.configureBlocking(false);
        //网络地址
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",9999);

        //连接服务端
        boolean connect = channel.connect(address);
        
        if(!connect){
            //如果连接失败
           while(!channel.finishConnect()){
               System.out.println("如果连接失败，还可以做其他的事");
           }
        }

        String msg = "hello server!";
        ByteBuffer writeBuffer = ByteBuffer.wrap(msg.getBytes());

        channel.write(writeBuffer);

        System.in.read();//阻塞，防止程序中止
    }

}
