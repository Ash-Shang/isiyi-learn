package com.isiyi.netty.nio.fileio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIOFileIoTest1
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/21 9:49
 * @Version 1.0
 */
public class NIOFileIoTest1 {

    @Test
    public void testWrite() throws Exception{

        FileOutputStream fileOutputStream = new FileOutputStream("nio.txt");
        //从流种获取通道
        FileChannel channel = fileOutputStream.getChannel();

        //缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello,nio".getBytes());
        buffer.flip();
        //把缓冲区写到通道种
        channel.write(buffer);

        //关闭流
        fileOutputStream.close();

    }

    @Test
    public void testRead() throws Exception{

        FileInputStream fileInputStream = new FileInputStream("nio.txt");
        FileChannel channel = fileInputStream.getChannel();

        //定义缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);

      //  buffer.flip();

        byte[] array = buffer.array();
        System.out.println(new String(array));
        fileInputStream.close();


    }

    @Test
    public  void copyFile() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("nio.txt");

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\learn");

        FileChannel inputStreamChannel = fileInputStream.getChannel();

        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        outputStreamChannel.transferFrom(inputStreamChannel, 0, inputStreamChannel.size());

        //inputStreamChannel.transferTo(0,outputStreamChannel.size(), outputStreamChannel);

        fileInputStream.close();
        fileOutputStream.close();
    }


}
