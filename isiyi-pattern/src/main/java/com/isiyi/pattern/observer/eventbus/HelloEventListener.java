package com.isiyi.pattern.observer.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * 时间监听
 * <p></p>
 *
 * @version 1.0.0
 * @description: 时间监听
 * @author: siyi
 * @since: 2021/4/24
 */
public class HelloEventListener {

    @Subscribe
    public void listen(OrderEvent event) {
        System.out.println("receive1 msg:" + event.getMessage());
    }


    @Subscribe
    public void listen(String event) {
        System.out.println("receive2 msg:" + event);
    }


    @Subscribe
    public void listen(Integer event) {
        System.out.println("receive3 msg:" + event);
    }

}
