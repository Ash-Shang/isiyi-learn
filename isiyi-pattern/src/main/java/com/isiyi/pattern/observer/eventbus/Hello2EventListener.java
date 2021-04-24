package com.isiyi.pattern.observer.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: 类描述
 * @author: siyi
 * @since: 2021/4/24
 */
public class Hello2EventListener {

    @Subscribe
    public void listen(OrderEvent event) {
        System.out.println("hello2 receive2 msg:" + event.getMessage());
    }
    @Subscribe
    public void listen(String event) {
        System.out.println("hello2 receive2 msg:" + event);
    }

}
