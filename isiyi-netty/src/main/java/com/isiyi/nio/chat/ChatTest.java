package com.isiyi.nio.chat;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: Chattest
 * @author: 向鹏飞
 * @since: 2021/5/1
 */
public class ChatTest {

    @Test
    public void testServer(){
        ChatServer chatServer = new ChatServer();
        chatServer.listen();
    }

    @Test
    public void testClient(){
        try {
            ChatClient chatClient = new ChatClient();
            new Thread(() -> {
                while (true) {
                    try {
                        chatClient.read();
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                chatClient.send(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
