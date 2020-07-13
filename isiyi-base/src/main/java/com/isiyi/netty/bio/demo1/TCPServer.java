package com.isiyi.netty.bio.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPServer
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/21 9:23
 * @Version 1.0
 *
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        while (true){
            Socket accept = serverSocket.accept();//阻塞

            InputStream inputStream = accept.getInputStream();//阻塞

            byte[] b = new byte[20];
            inputStream.read(b);

            System.out.println("接受客户端信息："+new String(b));

            //回复信息
            OutputStream outputStream = accept.getOutputStream();//阻塞
            outputStream.write("abcde".getBytes());
            accept.close();
        }
    }
}
