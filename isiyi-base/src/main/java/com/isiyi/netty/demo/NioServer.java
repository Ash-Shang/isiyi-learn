package com.isiyi.netty.demo;

import javax.sound.sampled.Port;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName NioServer
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/4/6 18:05
 * @Version 1.0
 */
public class NioServer {

    private   int port = 9090;
    private InetSocketAddress address = null;
    private Selector selector;
    public  NioServer(int port){
        try {

            this.port = port;
            address = new InetSocketAddress(this.port);
            //创建server对象
            ServerSocketChannel server = ServerSocketChannel.open();
            //绑定端口
            server.bind(address);
            server.configureBlocking(false);
            //
            selector = Selector.open();

            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("基本配置成功*************************8");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //监听
    public void listen(){
        try {

            while (true){
                //判断连接数
                int select = this.selector.select();
                if(0 == select) continue;

                Set<SelectionKey> selectionKeys = this.selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    //处理事件
                    process(key);
                    //删除事件
                    iterator.remove();

                }
            }

        }catch (Exception e){

        }
    }

    //事件处理
    public void process(SelectionKey key) throws Exception{

        ByteBuffer buffer =  ByteBuffer.allocate(1024);

        //连接事件
        if(key.isAcceptable()){
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel accept = serverSocketChannel.accept();
            accept.configureBlocking(false);
            accept.register(selector, SelectionKey.OP_READ);

        } else if(key.isReadable()){
            SocketChannel socketChannel = (SocketChannel) key.channel();
            int read = socketChannel.read(buffer);

            if(read > 0){
                buffer.flip();
                String msg = new String(buffer.array(), 0 , buffer.limit());
                System.out.println("获取的数据： "+msg);
                //注册写事件
                socketChannel.register(selector, SelectionKey.OP_WRITE);
            }
            //buffer回收
            buffer.clear();

        }else if(key.isWritable()){
            SocketChannel socketChannel = (SocketChannel) key.channel();
            socketChannel.write(ByteBuffer.wrap("这事服务端发过来的信息".getBytes()));
        }
    }

    public static void main(String[] args) {
        new NioServer(9090).listen();
    }

}
