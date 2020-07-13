package com.isiyi.netty.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @ClassName NIOServer
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/21 15:17
 * @Version 1.0
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {

        //得到一个server对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到一个selector对象
        Selector selector = Selector.open();
        //配置server通道
        serverSocketChannel.bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        //把server对象注册到selector对象
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //do something
        while (true){

            if(selector.select(2000) == 0){
                System.out.println("没有客户端连接，我做点别的事");
            }

            Iterator<SelectionKey> iterator =
                    selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if(selectionKey.isAcceptable()){//客户端连接事件

                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    //将该selector注
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }


                if(selectionKey.isReadable()){//客户端连接事件
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    socketChannel.read(byteBuffer);

                    System.out.println("客户端发过来的信息为："+ new String(byteBuffer.array()));
                }

                iterator.remove();//处理完成，删除掉key,防止重复处理
            }

        }
    }

}
