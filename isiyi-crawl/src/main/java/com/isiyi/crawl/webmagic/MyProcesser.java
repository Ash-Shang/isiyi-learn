package com.isiyi.crawl.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * 页面解析
 */
public class MyProcesser implements PageProcessor {

    /**
     * 解析页面
     * @param page
     */
    @Override
    public void process(Page page) {
        Selectable selectable = page.getHtml()
                .xpath("//div[@id='list']/table/tbody/tr");

        List<Selectable> nodes = selectable.nodes();
        nodes.stream().forEach(n ->{
            String ipStr = n.xpath("tr/td[1]/text()").get();
            String port = n.xpath("tr/td[2]/text()").get();
            String secret = n.xpath("tr/td[3]/text()").get();
            String type = n.xpath("tr/td[4]/text()").get();
            String address = n.xpath("tr/td[5]/text()").get();
            String speed = n.xpath("tr/td[6]/text()").get();
            String time = n.xpath("tr/td[7]/text()").get();
            System.out.println(ipStr+"--"+port+"--"+secret+"--"+type+"--"+address+"--"+speed+"--"+time);
            System.out.println("********************************************");
        });



    }

    @Override
    public Site getSite() {
        return Site.me().setCharset("utf8");


    }

    public static void main(String[] args) {
        Spider.create(
                new MyProcesser()

        )
                .addPipeline(new MyPipeline())
                .addUrl("https://www.kuaidaili.com/free/inha/1")
                .run();
    }
}
