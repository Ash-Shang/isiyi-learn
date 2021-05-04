package com.isiyi.netty.tcp;

import org.junit.Test;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: TcpTest
 * @author: 向鹏飞
 * @since: 2021/5/3
 */
public class TcpTest {

    @Test
    public void testServer(){
        TcpServer tcpServer = new TcpServer();
        tcpServer.server();
    }

    @Test
    public void testClient(){
        TcpClient tcpClient = new TcpClient();
        tcpClient.client();
    }

}
