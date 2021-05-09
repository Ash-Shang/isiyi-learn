package com.isiyi.prototype;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: 类描述
 * @author: siyi
 * @since: 2021/5/9
 */
public class SearchWord implements Cloneable{

    private String keyword;

    private String count;

    private long lastUpdateTime;

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
