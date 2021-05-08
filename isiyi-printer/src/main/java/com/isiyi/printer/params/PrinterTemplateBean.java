package com.isiyi.printer.params;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: PrinterTemplateBean
 * @author: 向鹏飞
 * @since: 2021/5/7
 */
public class PrinterTemplateBean {

    private List<JSONObject> header;

    private List<JSONObject> operationInfo;

    private List<Goods> goods;

    private List<Map<String, Object>> goodParam;

    private List<JSONObject> bill;

    private List<JSONObject> footer;

    public List<JSONObject> getHeader() {
        return header;
    }

    public void setHeader(List<JSONObject> header) {
        this.header = header;
    }

    public List<JSONObject> getOperationInfo() {
        return operationInfo;
    }

    public void setOperationInfo(List<JSONObject> operationInfo) {
        this.operationInfo = operationInfo;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<JSONObject> getBill() {
        return bill;
    }

    public void setBill(List<JSONObject> bill) {
        this.bill = bill;
    }

    public List<JSONObject> getFooter() {
        return footer;
    }

    public void setFooter(List<JSONObject> footer) {
        this.footer = footer;
    }

    public List<Map<String, Object>> getGoodParam() {
        return goodParam;
    }

    public void setGoodParam(List<Map<String, Object>> goodParam) {
        this.goodParam = goodParam;
    }
}
