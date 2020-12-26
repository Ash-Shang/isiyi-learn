package com.isiyi.crawl.demo1;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpPostPramTest {

    @Test
    public  void mainTest() {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse httpResponse = null;
        try{
            //请求路径或者参数封装
            HttpPost httpPost = new HttpPost("https://www.51zxw.net/NewAn/WebSearch/Course");

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("keyWords","java"));
            //第一个参数，是请求的参数，， 第二个参数是编码
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf8");
            httpPost.setEntity(formEntity);

            httpResponse = httpClient.execute(httpPost);
            if (200 == httpResponse.getStatusLine().getStatusCode()) {
                HttpEntity entity = httpResponse.getEntity();
                String content = EntityUtils.toString(entity, "utf-8");
                System.out.println(content);
            }
            httpResponse.close();
            httpClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != httpResponse){
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != httpClient){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
