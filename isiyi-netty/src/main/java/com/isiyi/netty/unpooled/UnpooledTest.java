package com.isiyi.netty.unpooled;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

/**
 * 缓冲区的工具类
 * <p></p>
 *
 * @version 1.0.0
 * @description: 缓冲区的工具类
 * @author: 向鹏飞
 * @since: 2021/5/5
 */
public class UnpooledTest {

    @Test
    public void test01(){
        ByteBuf buffer = Unpooled.buffer(10);
        for (int i = 0; i < 7; i++) {
            buffer.writeByte(i);
        }
        System.out.println("capacity:" + buffer.capacity());

        byte aByte = buffer.getByte(2);
        System.out.println(aByte);
    }

}
