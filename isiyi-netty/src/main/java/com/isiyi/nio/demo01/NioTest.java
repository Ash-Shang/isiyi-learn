package com.isiyi.nio.demo01;

import org.junit.Test;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: NioTest
 * @author: 向鹏飞
 * @since: 2021/5/3
 */
public class NioTest {

    @Test
    public void testServer() throws Exception{
        NIOServer nioServer = new NIOServer();
        nioServer.server();
    }

    @Test
    public void testClient() throws Exception{
        NIOClient client = new NIOClient();
        client.client();
    }
}
