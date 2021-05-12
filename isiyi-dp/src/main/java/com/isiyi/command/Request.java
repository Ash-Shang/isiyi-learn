package com.isiyi.command;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: 类描述
 * @author: siyi
 * @since: 2021/5/12
 */
public class Request {

    Event event;

    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
