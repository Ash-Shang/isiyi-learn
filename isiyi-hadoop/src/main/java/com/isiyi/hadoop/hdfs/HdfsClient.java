package com.isiyi.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

/**
 * hdfs 配置类
 * <p></p>
 *
 * @version 1.0.0
 * @description: HdfsClient
 * @author: 向鹏飞
 * @since: 2021/6/12
 */
public class HdfsClient {

    private final static String HDFS_URI = "hdfs://127.0.0.1:9000";
    private final static String PERMISSION_USER = "root";

    @Before
    public void before(){
        System.setProperty("hadoop.home.dir", "D:\\developer\\hadoop314");
    }
    /***
     * 文件夹创建
     * @throws Exception
     */
    @Test
    public void testMkdirs() throws Exception{

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 配置在集群上运行
        // configuration.set("fs.defaultFS", "hdfs://cdh01:9000");
        // FileSystem fs = FileSystem.get(configuration);

        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 创建目录
        fs.mkdirs(new Path("/test/cdh02"));

        // 3 关闭资源
        fs.close();
    }

    /***
     * 文件上传
     * @throws Exception
     */
    @Test
    public void testCopyFromLocalFile() throws Exception{
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        configuration.set("dfs.replication", "1");
        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 上传文件
        fs.copyFromLocalFile(new Path("E:/appdata/emp_gender.txt"), new Path("/test/cdh01/emp_gender.txt"));

        // 3 关闭资源
        fs.close();

        System.out.println("over");
    }


    @Test
    public void testCopyToLocalFile() throws Exception{

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 执行下载操作
        // boolean delSrc 指是否将原文件删除
        // Path src 指要下载的文件路径
        // Path dst 指将文件下载到的路径
        // boolean useRawLocalFileSystem 是否开启文件校验
        fs.copyToLocalFile(false, new Path("/test/cdh03/wordcount.txt"), new Path("E:/appdata/out/wordcount.txt"), true);

        // 3 关闭资源
        fs.close();
    }

    /***
     * 删除文件
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception{
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 执行删除
        fs.delete(new Path("/test/cdh03/"), true);

        // 3 关闭资源
        fs.close();
    }


    /***
     * 测试文件名更改
     * @throws Exception
     */
    @Test
    public void testRename() throws Exception{
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 修改文件名称
        fs.rename(new Path("/test/cdh03/wordcount.txt"), new Path("/test/cdh03/new_wordcount.txt"));

        // 3 关闭资源
        fs.close();
    }

    /***
     * 文件详情查看
     * @throws Exception
     */
    @Test
    public void testListFiles() throws Exception{
// 1获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 获取文件详情
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

        while(listFiles.hasNext()){
            LocatedFileStatus status = listFiles.next();

            // 输出详情
            // 文件名称
            System.out.println(status.getPath().getName());
            // 长度
            System.out.println(status.getLen());
            // 权限
            System.out.println(status.getPermission());
            // 分组
            System.out.println(status.getGroup());

            // 获取存储的块信息
            BlockLocation[] blockLocations = status.getBlockLocations();

            for (BlockLocation blockLocation : blockLocations) {

                // 获取块存储的主机节点
                String[] hosts = blockLocation.getHosts();

                for (String host : hosts) {
                    System.out.println(host);
                }
            }

            System.out.println("-----------班长的分割线----------");
        }

        // 3 关闭资源
        fs.close();

    }

    /***
     * HDFS文件和文件夹判断
     * @throws Exception
     */
    @Test
    public void testListStatus() throws Exception{
// 1 获取文件配置信息
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(HDFS_URI), configuration, PERMISSION_USER);

        // 2 判断是文件还是文件夹
        FileStatus[] listStatus = fs.listStatus(new Path("/test"));

        for (FileStatus fileStatus : listStatus) {

            // 如果是文件
            if (fileStatus.isFile()) {
                System.out.println("f:"+fileStatus.getPath().getName());
            }else {
                System.out.println("d:"+fileStatus.getPath().getName());
            }
        }

        // 3 关闭资源
        fs.close();
    }
}
