package com.isiyi.printer.params;
import java.util.List;
import java.util.Map;

/**
 * 需要打印的参数
 *
 * @author SubLuLu
 */
public class PosParam {

    // 替换模板中占位符的参数
    private Map<String, Object> keys;
    // 商品信息参数集合
    private List<Map<String, Object>> goods;

    private List<Map<String, Object>> itemGoods;

    private List<Map<String, Object>> setMealGoods;

    private List<Map<String, Object>> giveGoods;

    private List<Map<String, Object>> returnGoods;

    public Map<String, Object> getKeys() {
        return keys;
    }

    public void setKeys(Map<String, Object> keys) {
        this.keys = keys;
    }

    public List<Map<String, Object>> getItemGoods() {
        return itemGoods;
    }

    public void setItemGoods(List<Map<String, Object>> itemGoods) {
        this.itemGoods = itemGoods;
    }

    public List<Map<String, Object>> getSetMealGoods() {
        return setMealGoods;
    }

    public void setSetMealGoods(List<Map<String, Object>> setMealGoods) {
        this.setMealGoods = setMealGoods;
    }

    public List<Map<String, Object>> getGiveGoods() {
        return giveGoods;
    }

    public void setGiveGoods(List<Map<String, Object>> giveGoods) {
        this.giveGoods = giveGoods;
    }

    public List<Map<String, Object>> getReturnGoods() {
        return returnGoods;
    }

    public void setReturnGoods(List<Map<String, Object>> returnGoods) {
        this.returnGoods = returnGoods;
    }

    public List<Map<String, Object>> getGoods() {
        return goods;
    }

    public void setGoods(List<Map<String, Object>> goods) {
        this.goods = goods;
    }

}
