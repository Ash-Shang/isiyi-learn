package com.isiyi.crawl.processer;


//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.processor.PageProcessor;
//import us.codecraft.webmagic.selector.Html;
//import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class MyProcessor
      //  implements PageProcessor
{

//    @Override
//    public void process(Page page)  {
//        try {
//            Html html = page.getHtml();
//            Selectable selectable = html.xpath("//div[@id='list']//table//tbody//");
//            List<Selectable> selectableList = selectable.nodes();
//            for (int i = 1; i < selectableList.size(); i++) {
//                Selectable sonNode = selectableList.get(i);
//                Selectable tdTestNodes = sonNode.xpath("tr//td");
//                List<Selectable> tdNodeList = tdTestNodes.nodes();
//                for (Selectable selectable1 : tdNodeList) {
//                    String s = selectable1.get();
//                    System.out.print(s);
//                    System.out.print("--");
//                }
//                System.out.println();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Site getSite() {
//        return Site.me().setSleepTime(100).setRetryTimes(3);
//    }
//
//    public static void main(String[] args) {
//        Spider.create( new MyProcessor()).addUrl("https://www.kuaidaili.com/free/inha/1").run();
//    }

}
