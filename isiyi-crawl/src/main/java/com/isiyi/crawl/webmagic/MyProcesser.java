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
                .css("#list > table > tbody > tr");

        List<Selectable> nodes = selectable.nodes();
        nodes.stream().forEach(n ->{
            System.out.println(n.toString());
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
