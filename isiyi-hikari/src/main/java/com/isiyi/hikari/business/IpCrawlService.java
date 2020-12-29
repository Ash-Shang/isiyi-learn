package com.isiyi.hikari.business;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.isiyi.hikari.domain.IpDomain;
import com.isiyi.hikari.enums.SourceTypeEnum;
import com.isiyi.hikari.service.IpService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class IpCrawlService {

    /**
     * 获取网页的超时时间
     */
    private static int TIME_OUT = 100000;

    @Autowired
    private IpService ipService;


    public void crawlKuaiDaiLi(int page){
        String kdlUrl = "https://www.kuaidaili.com/free/inha/";

        try {
            String url = kdlUrl + page;
            Document document = Jsoup.parse(new URL(url), TIME_OUT);
            Elements selectElement = document.select("#list > table > tbody > tr");
            Iterator<Element> trIterator = selectElement.iterator();
            List<IpDomain> ipDomainList = new ArrayList<>(16);
            while (trIterator.hasNext()) {
                Element trElement = trIterator.next();
                Elements tdElement = trElement.select("td");

                IpDomain ipDomain = new IpDomain();

                ipDomain.setIpStr(tdElement.get(0).text());
                ipDomain.setPort(Integer.valueOf(tdElement.get(1).text()));
                String text = tdElement.get(2).text();
                int i = "高匿名".equals(text) ? 1 : 0;
                ipDomain.setSecretType(i);

                ipDomain.setRequestType(tdElement.get(3).text());
                String areaAndOperator = tdElement.get(4).text();
                if(StringUtils.isNotBlank(areaAndOperator)){
                    String[] s = areaAndOperator.split(" ");
                    if(s.length == 1){
                        ipDomain.setArea(s[0]);
                    }
                    if(s.length == 2){
                        ipDomain.setArea(s[0]);
                        ipDomain.setOperator(s[1]);
                    }
                }
                ipDomain.setSpeed(tdElement.get(5).text());
                DateTime dateTime = DateUtil.parse(tdElement.get(6).text());
                ipDomain.setCheckTime(dateTime);
                ipDomain.setSource(SourceTypeEnum.KUAI_DAI_LI.getSource());
                ipDomainList.add(ipDomain);
            }
            ipService.saveBatch(ipDomainList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
