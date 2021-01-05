package com.isiyi.crawl.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.net.URL;
import java.util.Iterator;

public class SelectorTest {

    static String URL = "https://www.kuaidaili.com/free/inha/1";
    static int TIME_OUT = 100000;
    @Test
    public  void testMain() {

        try {
            Document document = Jsoup.parse(new URL(URL), TIME_OUT);
            Elements selectElement = document.select("#list > table > tbody > tr");
            Iterator<Element> trIterator = selectElement.iterator();
            while (trIterator.hasNext()) {
                Element trElement = trIterator.next();
                Elements tdElement = trElement.select("td");
                Iterator<Element> iterator = tdElement.iterator();
                while (iterator.hasNext()) {
                    Element next = iterator.next();
                    System.out.print(next.text());
                    System.out.print("-");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
