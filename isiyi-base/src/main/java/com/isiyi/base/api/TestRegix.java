package com.isiyi.base.api;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @ClassName TestRegix
 * @Description 测试正则
 * @Author Ash-Shang
 * @Date 2020/2/13 23:07
 * @Version 1.0
 */
public class TestRegix {


    @Test
    public void RegixUrl(){

        String url1 = "vz813.hmd.sousheshi.com";
        String url2 = "vz813.hmd.sousheshi";
        String url3 = "192.168.10.101";
        String url4 = "app.wjxznshs.xyz";
        String url5 = "gz6a3.hmd.sousheshi.com";
        String url6 = "gz6a3.hmd.sousheshi.com.hmdxyzmkp";

        System.out.println( isUrl(url1));
        System.out.println( isUrl(url2));
        System.out.println( isUrl(url3));
        System.out.println( isUrl(url4));
        System.out.println( isUrl(url5));
        System.out.println( isUrl(url6));


    }

    public boolean isUrl(String url) {
        String regex = "^((https|http|ftp|rtsp|mms)?://)"
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
//                + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
//                + "|" // 允许IP和DOMAIN（域名）
                + "(([0-9a-z_!~*'()-]+\\.)*" // 域名- www.
//                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
                + "[a-z]{2,6})" // first level domain- .com or .museum
                + "(:[0-9]{1,4})?" // 端口- :80
                + "((/?)|" // a slash isn't required if there is no file name
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(url).matches();
    }

}
