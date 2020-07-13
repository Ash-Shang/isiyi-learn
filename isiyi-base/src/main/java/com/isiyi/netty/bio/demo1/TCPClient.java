package com.isiyi.netty.bio.demo1;



import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TCPClient
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/21 9:25
 * @Version 1.0
 */
public class TCPClient {

    public static void main(String[] args) throws Exception {
        while (true){
            Socket socket = new Socket("127.0.0.1", 9999);

            OutputStream outputStream = socket.getOutputStream();

            System.out.println("请输入。。。");

            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            outputStream.write(s.getBytes());

            //接受信息
            InputStream inputStream = socket.getInputStream();//阻塞，等待服务器回信息
            byte[] b = new byte[20];
            inputStream.read(b);
            System.out.println("收到回复："+new String(b));
            socket.close();
            TimeUnit.SECONDS.sleep(3);
        }
    }


}
