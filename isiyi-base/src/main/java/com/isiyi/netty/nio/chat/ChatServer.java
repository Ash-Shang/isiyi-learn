package com.isiyi.netty.nio.chat;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * @ClassName ChatServer
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/21 15:56
 * @Version 1.0
 */
public class ChatServer {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private static final int PORT = 9999;

    public ChatServer(){
        try {
            serverSocketChannel = ServerSocketChannel.open();

            selector = Selector.open();
            //配置端口
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            //配置阻塞方式
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("chat server is ready");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void start(){
        try {
            while (true){//不断监控

                if(selector.select(3000) == 0){
                    System.out.println("没有连接.....");
                    continue;
                }

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();

                    //接受就绪
                    if(key.isAcceptable()){
                        SocketChannel accept = serverSocketChannel.accept();
                        accept.configureBlocking(false);
                        //注册等待请求
                        accept.register(selector,SelectionKey.OP_READ);
                        System.out.println(accept.getRemoteAddress().toString() + ">>>上线啦!!!");

                    }
                    //读取就绪
                    if(key.isReadable()){
                        readMsg(key);
                    }


                    //处理完，删除掉,防止重复处理
                    iterator.remove();
                }
            }
        }catch (Exception e){

        }
    }

    /**
     *  读取客户端发过来的信息，并且广播出去
     *  @author: Ash-Shang
     *  @Date: 2020/3/21 17:29
     *  @Description:
     */
    public void readMsg(SelectionKey selectionKey) throws Exception{
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int read = channel.read(buffer);

        if(read>0){
            String msg = new String(buffer.array());
            //打印信息
            printInfo(msg);
            //广播信息
            broadCastMsg(msg, channel);
        }

    }

    /**
     *  广播排除自身的socketChannel
     *  @author: Ash-Shang
     *  @Date: 2020/3/21 17:38
     *  @Description:
     */
    public void  broadCastMsg(String msg, SocketChannel socketChannel) throws Exception{
        System.out.println("服务器发送广播");

        for(SelectionKey key: selector.keys()){
            SocketChannel channel = (SocketChannel) key.channel();

            if(channel instanceof SocketChannel &&  channel != socketChannel){
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                channel.write(byteBuffer);
            }


        }

    }

    public void printInfo(String msg){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("["+simpleDateFormat.format(new Date())+"] -> "+msg);
    }

    public static void main(String[] args) {

    }
}
