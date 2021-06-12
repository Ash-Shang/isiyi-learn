package com.isiyi.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;

/**
 * hdfs io流操作
 * <p></p>
 *
 * @version 1.0.0
 * @description: HdfsIOTest
 * @author: 向鹏飞
 * @since: 2021/6/12
 */
public class HdfsIOTest {
    private final static String HDFS_URI = "hdfs://127.0.0.1:9000";
    private final static String PERMISSION_USER = "root";

    @Before
    public void before(){
        System.setProperty("hadoop.home.dir", "D:\\developer\\hadoop314");
    }
    @Test
    public void testUploadByStream() throws Exception{
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 创建输入流
        FileInputStream fis = new FileInputStream(new File("E:/appdata/wordcount.txt"));

        // 3 获取输出流
        FSDataOutputStream fos = fs.create(new Path("/test/cdh01/wordcount.txt"));

        // 4 流对拷
        IOUtils.copyBytes(fis, fos, configuration);

        // 5 关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }

    @Test
    public void testDownByStream() throws Exception{
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 获取输入流
        FSDataInputStream fis = fs.open(new Path("/test/cdh01/wordcount.txt"));

        // 3 获取输出流
        FileOutputStream fos = new FileOutputStream(new File("E:/appdata/out/wordcount.txt"));

        // 4 流的对拷
        IOUtils.copyBytes(fis, fos, configuration);

        // 5 关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }


    /***
     * 定位
     * @throws Exception
     */
    @Test
    public void localFileAndRead() throws Exception{
// 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 获取输入流
        FSDataInputStream fis = fs.open(new Path("/test/cdh01/wordcount.txt"));

        // 3 创建输出流
        FileOutputStream fos = new FileOutputStream(new File("E:/appdata/out/new_wordcount.txt"));

        // 4 流的拷贝
        byte[] buf = new byte[1024];

        for(int i =0 ; i < 1024 * 128; i++){
            fis.read(buf);
            fos.write(buf);
            System.out.println(new String(buf));
        }

        // 5关闭资源
        IOUtils.closeStream(fis);
        IOUtils.closeStream(fos);
        fs.close();
    }
}
