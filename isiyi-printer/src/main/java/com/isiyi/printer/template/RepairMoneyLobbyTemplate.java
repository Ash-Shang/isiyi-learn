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
 * 银单(前厅)
 * <p></p>
 *
 * @version 1.0.0
 * @description: MoneyLobbyTemplate
 * @author: 向鹏飞
 * @since: 2021/5/8
 */
public class RepairMoneyLobbyTemplate {




    private static String TEMPLATE="{\n" +
            "    \"header\": [\n" +
            "        {\n" +
            "            \"text\": \"*结账单*\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"品牌LOGO：\",\n" +
            "            \"size\": 2,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"{$shopname}\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": true,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"努力不一定成功，放弃一定很轻松\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": true,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  ---------------------------------------\",\n" +
            "            \"format\": 0,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 1,\n" +
            "            \"type\": 0\n" +
            "        }\n" +
            "    ],\n" +
            "    \"operationInfo\": [\n" +
            "        {\n" +
            "            \"text\": \" 订单号：{$orderNo}\",\n" +
            "            \"format\": 0,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 1,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \" 操作员：{$operator}\",\n" +
            "            \"format\": 0,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 0,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  机号：{$machineNo}\",\n" +
            "            \"format\": 2,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 1,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \" 台  号：{$tableNo}\",\n" +
            "            \"format\": 0,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 0,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  人数：{$num}\",\n" +
            "            \"format\": 2,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 1,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \" 开台时间：{$orderTime}\",\n" +
            "            \"format\": 0,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 1,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  ---------------------------------------\",\n" +
            "            \"format\": 0,\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"line\": 1,\n" +
            "            \"type\": 0\n" +
            "        }\n" +
            "    ],\n" +
            "    \"goods\": [\n" +
            "        {\n" +
            "            \"name\": \"单品菜品名\",\n" +
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
            "            \"name\": \"金额\",\n" +
            "            \"width\": 8,\n" +
            "            \"format\": 2,\n" +
            "            \"variable\": \"pay\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"footer\": [\n" +
            "        {\n" +
            "            \"text\": \"  ---------------------------------------\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  消费金额：{$consumeAmount}\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  优惠总额：{$discountedAmount}\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  已付金额：{$paidAmount}\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  ---------------------------------------\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"付款明细：\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"{$payType}   {$paidAmount}\",\n" +
            "            \"size\": 5,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"({$orderNum})\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  ---------------------------------------\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"http://www.gtmsh.com\",\n" +
            "            \"format\": 1,\n" +
            "            \"line\": 1,\n" +
            "            \"type\": 2\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  ---------------------------------------\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  联系电话：{$phone}\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  地址：{$address}\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  ---------------------------------------\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  这是一个广告尾巴。。\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  ---------------------------------------\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": false,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"text\": \"  (补打{$repairCount}……)\",\n" +
            "            \"size\": 1,\n" +
            "            \"bold\": true,\n" +
            "            \"format\": 0,\n" +
            "            \"line\": 1,\n" +
            "            \"underline\": false,\n" +
            "            \"type\": 0\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static String PARAM = "{\n" +
            "  \"keys\": {\n" +
            "    \"shopname\": \"探鱼烤鱼\",\n" +
            "    \"orderNo\": \"6921734976505\",\n" +
            "    \"operator\": \"小欧\",\n" +
            "    \"machineNo\": \"963258741\",\n" +
            "    \"tableNo\": 14,\n" +
            "    \"num\": 3,\n" +
            "    \"orderTime\": \"2021-05-7 12:30:42\",\n" +
            "    \"discountType\": \"全单折扣(90%)\",\n" +
            "    \"discountAmount\": \"20\",\n" +
            "    \"activityName\": \"周年活动\",\n" +
            "    \"activityAmount\": \"30\",\n" +
            "    \"consumeAmount\": \"160\",\n" +
            "    \"discountedAmount\": \"50\",\n" +
            "    \"paidAmount\": \"90\",\n" +
            "    \"unpaidAmount\": \"20\",\n" +
            "    \"payType\": \"支付宝\",\n" +
            "    \"repairCount\": \"1\",\n" +
            "    \"orderNum\": \"1234567898765421\",\n" +
            "    \"phone\": \"0755-536883825\",\n" +
            "    \"address\": \"广东省深圳市南山区蛇口街道中心路2233号宝能太古城北区NB130-2号铺\"\n" +
            "  },\n" +
            "  \"goods\": [\n" +
            "    {\n" +
            "      \"name\": \"青椒烤鱼\",\n" +
            "      \"num\": 1,\n" +
            "      \"pay\": 120.8\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"酱香烤鱼\",\n" +
            "      \"num\": 1,\n" +
            "      \"pay\": 114.8\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"辣椒炒肉\",\n" +
            "      \"num\": 1,\n" +
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

        PrintServer printServer = PrintServer.getInstance(PrinterConstant.IP_TM_T82III);
        printServer.init();
        // 打印文件头
        for (JSONObject jsonObject : printerTemplateBean.getHeader()) {
            printServer.print(jsonObject);
        }
        //打印 操作信息
        for (JSONObject jsonObject : printerTemplateBean.getOperationInfo()) {
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
        // 打印文件尾
        for (JSONObject jsonObject : printerTemplateBean.getFooter()) {
            printServer.print(jsonObject);
        }
        printServer.line(1);
        printServer.end();
    }

}
