package com.isiyi.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 聊天室服务端
 * <p></p>
 *
 * @version 1.0.0
 * @description: 聊天室服务端
 * @author: 向鹏飞
 * @since: 2021/5/1
 */
public class ChatServer {

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private final static int PORT = 6667;

    //初始化工作
    public ChatServer(){
        try {
            //初始化selector
            selector = Selector.open();
            //得到serverSocketChannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞
            listenChannel.configureBlocking(false);
            //将listenChannel 注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 监听
    public void listen(){
        try {
            while (true) {
                int select = selector.select(2000);
                //有事件处理
                if (select > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        //监听到accept
                        if (selectionKey.isAcceptable()) {
                            SocketChannel socketChannel = listenChannel.accept();
                            socketChannel.configureBlocking(false);
                            //注册可读事件
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            // 提示
                            System.out.println(socketChannel.getRemoteAddress()+"上线了。。。");
                        }
                        //监听读事件
                        if (selectionKey.isReadable()) {
                            read(selectionKey);
                        }
                        iterator.remove();
                    }
                }else {
                    System.out.println("等待事件处理.....");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 处理读事件
    private void read(SelectionKey selectionKey){
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) selectionKey.channel();
            //创建buffer ,收集数据
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(byteBuffer);
            if(read > 0){
                String s = new String(byteBuffer.array());
                System.out.println("from 客户端：" + s);
                // 向其他客户端转发消息
                transferMessage(s, socketChannel);
            }

        }catch (Exception e){
            try {
                System.out.println(socketChannel.getRemoteAddress()+ "离线了。。。。");
                //取消注册
                selectionKey.cancel();
                // 关闭通道
                socketChannel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    //将消息转发给其他人
    private void transferMessage(String msg, SocketChannel selfChannel) throws IOException {
        System.out.println("服务器转发消息......");

        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        for (SelectionKey selectionKey : selectionKeys) {
            SelectableChannel channel = selectionKey.channel();
            if(channel instanceof SocketChannel && channel != selfChannel){
                SocketChannel targetChannel = (SocketChannel) channel;
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                targetChannel.write(byteBuffer);
            }
        }
    }

}
