package com.isiyi.netty.chat;

import org.junit.Test;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: ChatTest
 * @author: 向鹏飞
 * @since: 2021/5/5
 */
public class ChatTest {

    @Test
    public void testServer(){
        ChatServer.server();
    }

    @Test
    public void testClient(){
        ChatClient.client();
    }
}
