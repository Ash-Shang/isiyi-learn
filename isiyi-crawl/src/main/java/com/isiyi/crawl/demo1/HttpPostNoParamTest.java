package com.isiyi.crawl.demo1;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class HttpPostNoParamTest {

    @Test
    public  void mainTest() {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpGet = new HttpPost("https://www.kuaidaili.com/free/inha/1");

        CloseableHttpResponse httpResponse = null;
        try{
            httpResponse = httpClient.execute(httpGet);
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
