package com.isiyi.crawl.demo1;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class HttpGetParamTest {

    @Test
    public  void mainTest() {
        CloseableHttpClient httpClient = HttpClients.createDefault();



        CloseableHttpResponse httpResponse = null;
        try{
            URIBuilder builder = new URIBuilder("http://search.dangdang.com/");
            builder
                    .setParameter("key", "python")
                    .setParameter("act","input");


            HttpGet httpGet = new HttpGet(builder.build());

            httpResponse = httpClient.execute(httpGet);
            if (200 == httpResponse.getStatusLine().getStatusCode()) {
                HttpEntity entity = httpResponse.getEntity();
                String content = EntityUtils.toString(entity, "utf-8");
                System.out.println(content);
            }else {
                System.out.println("没有爬取到数据");
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
