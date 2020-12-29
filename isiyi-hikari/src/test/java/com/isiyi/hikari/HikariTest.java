package com.isiyi.hikari;


import com.isiyi.hikari.business.IpCrawlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HikariApplication.class)
public class HikariTest {

    @Autowired
    private IpCrawlService ipCrawlService;

    @Test
    public void testCrawlKdl(){

        int i = 1;

        ipCrawlService.crawlKuaiDaiLi(i);


    }

}
