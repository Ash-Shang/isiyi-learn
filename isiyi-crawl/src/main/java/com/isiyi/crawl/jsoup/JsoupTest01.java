package com.isiyi.crawl.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.net.URL;
import java.util.Iterator;

public class JsoupTest01 {

    static String URL = "https://www.kuaidaili.com/free/inha/1";
    static int TIME_OUT = 100000;
    @Test
    public  void testMain(){

        try {
            Document document = Jsoup.parse(new URL(URL), TIME_OUT);
            Element elementById = document.getElementById("list");
            Elements elementsByTag = elementById.getElementsByTag("tbody");
            Element elements = elementsByTag.first();
            Elements trElements = elements.getElementsByTag("tr");
            Iterator<Element> trIterator = trElements.iterator();
            while (trIterator.hasNext()){
                Element next = trIterator.next();
                Elements tdElement = next.getElementsByTag("td");
                Iterator<Element> tdIterator = tdElement.iterator();

                while (tdIterator.hasNext()) {
                    Element element = tdIterator.next();
                    String text = element.text();
                    System.out.print(text);
                    System.out.print("--");
                }
                System.out.println();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
