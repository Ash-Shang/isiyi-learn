package com.isiyi.netty.demo;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName BIOClient
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/4/6 18:24
 * @Version 1.0
 */
public class BIOClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 9090);
        OutputStream outputStream = socket.getOutputStream();


        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        outputStream.write(s.getBytes());

        //接受服务端的数据

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        if(read > 0){
            String s1 = new String(bytes);
            System.out.println("客户端接受到的信息："+ s1);
        }



    }

}
