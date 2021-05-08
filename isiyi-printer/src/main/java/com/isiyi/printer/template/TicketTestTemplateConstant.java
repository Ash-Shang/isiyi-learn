package com.isiyi.printer.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.isiyi.printer.PrintServer;
import com.isiyi.printer.constant.PrinterConstant;
import com.isiyi.printer.params.Goods;
import com.isiyi.printer.params.PosParam;
import com.isiyi.printer.params.PrinterTemplateBean;
import com.isiyi.printer.utils.PrintTemplateUtil;

import java.util.List;
import java.util.Map;

/**
 * 小票模板
 * <p></p>
 *
 * @version 1.0.0
 * @description: 小票模板
 * @author: 向鹏飞
 * @since: 2021/4/28
 */
public class TicketTestTemplateConstant {

    public static String TEMPLATE="{\n" +
            "    \"header\": [\n" +
            "        {\n" +
            "            \"text\": \"{$shopname}\",\n" +
            "            \"size\": 2,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"underline\": true,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"{$barCode}\",\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"type\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"path\": \"{$logo}\",\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"type\": 3\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"---------------------------------------\",\n" +
            "            \"format\": 0,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 2,\n" +
            "            \"type\": 0\n" +
            "        }\n" +
            "    ],\n" +
            "    \"goods\": [\n" +
            "        {\n" +
            "            \"name\": \"商品名\",\n" +
            "            \"width\": 24,\n" +
            "            \"format\": 0,\n" +
            "            \"variable\": \"name\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"数量\",\n" +
            "            \"width\": 8,\n" +
            "            \"format\": 1,\n" +
            "            \"variable\": \"num\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"单价\",\n" +
            "            \"width\": 8,\n" +
            "            \"format\": 1,\n" +
            "            \"variable\": \"price\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"金额\",\n" +
            "            \"width\": 8,\n" +
            "            \"format\": 2,\n" +
            "            \"variable\": \"pay\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"bill\": [\n" +
            "        {\n" +
            "            \"text\": \"实收现金\",\n" +
            "            \"size\": 3,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"{$cash}\",\n" +
            "            \"size\": 3,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        }\n" +
            "    ],\n" +
            "    \"footer\": [\n" +
            "        {\n" +
            "            \"text\": \"详情请访问官网\",\n" +
            "            \"size\": 2,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"underline\": true,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"http://www.sublulu.com\",\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 2,\n" +
            "            \"type\": 2\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static String PARAMS="{\n" +
            "  \"keys\": {\n" +
            "    \"shopname\": \"探鱼烤鱼\",\n" +
            "    \"barCode\": \"6921734976505\",\n" +
            "    \"qrCode\": \"http://www.sublulu.com\",\n" +
            "    \"time\": \"15:35\",\n" +
            "    \"num\": 14,\n" +
            "    \"cash\": 324.5,\n" +
            "    \"logo\": \"/sdcard/qr.png\",\n" +
            "    \"adv\": \"关注微信，有大大地活动哦\"\n" +
            "  },\n" +
            "  \"goods\": [\n" +
            "    {\n" +
            "      \"name\": \"青椒烤鱼\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 121.8,\n" +
            "      \"pay\": 120.8\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"酱香烤鱼\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 114.8,\n" +
            "      \"pay\": 114.8\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"辣椒炒肉\",\n" +
            "      \"num\": 1,\n" +
            "      \"price\": 14.8,\n" +
            "      \"pay\": 14.8\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static PrinterTemplateBean renderTemplate(String param){
        JSONObject jsonObject = JSON.parseObject(param);


        Map<String, Object> mapObj = (Map<String, Object>) jsonObject.get(PrinterConstant.KEYS);
        String render = PrintTemplateUtil.render(TEMPLATE, mapObj);

        PrinterTemplateBean printerTemplateBean = JSON.parseObject(render, PrinterTemplateBean.class);

        PosParam posParam = JSON.parseObject(param, PosParam.class);
        List<Map<String, Object>> goods = posParam.getGoods();
        printerTemplateBean.setGoodParam(goods);

        return printerTemplateBean;
    }

    public static void print(String param) throws Exception{
        PrinterTemplateBean printerTemplateBean = renderTemplate(param);
        List<Map<String, Object>> goodsParam = printerTemplateBean.getGoodParam();
        // 打印文件头
        PrintServer printServer = PrintServer.getInstance(PrinterConstant.IP_TM_T82III);

        for (JSONObject jsonObject : printerTemplateBean.getHeader()) {
            printServer.print(jsonObject);
        }

        // 打印标题
        for (Goods goods : printerTemplateBean.getGoods()) {
            printServer.printTitle(goods);
        }
        printServer.line(1);

        // 打印详情
        for (Map<String, Object> goods : goodsParam) {
            printServer.printGoods(goods, printerTemplateBean.getGoods());
        }

        // 打印金额
        for (JSONObject jsonObject : printerTemplateBean.getBill()) {
            printServer.print(jsonObject);
        }

        // 打印文件尾
        for (JSONObject jsonObject : printerTemplateBean.getFooter()) {
            printServer.print(jsonObject);
        }
        printServer.line(1);
        printServer.end();
    }
}
