package com.isiyi.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 聊天室的客户端
 * <p></p>
 *
 * @version 1.0.0
 * @description: 聊天室的客户端
 * @author: 向鹏飞
 * @since: 2021/5/1
 */
public class ChatClient {
    //定义属性
    private final static String IP = "127.0.0.1";
    private final static int PORT = 6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;
    // 定义构造函数
    public ChatClient () throws Exception{
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(IP, PORT));
        // 设置非阻塞
        socketChannel.configureBlocking(false);
        //将channel 注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        userName = socketChannel.getLocalAddress().toString().substring(1);

        System.out.println(userName + "is ok..");
    }

    //发送消息
    public void send(String message) throws Exception{
        message = userName + "说：" + message;
        socketChannel.write(ByteBuffer.wrap(message.getBytes()));
    }
    //读消息
    public void read() throws IOException {
        int select = selector.select();
        //判断是否有用的通道
        if (select > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    channel.read(byteBuffer);

                    String s = new String(byteBuffer.array());
                    System.out.println(s.trim());
                    iterator.remove();
                }
            }
        }else {
            System.out.println("没有可用的通道。。。。。。");
        }
    }



}
