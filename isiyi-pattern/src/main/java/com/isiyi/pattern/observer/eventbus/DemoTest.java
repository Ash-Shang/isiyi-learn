package com.isiyi.pattern.observer.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: 类描述
 * @author: siyi
 * @since: 2021/4/24
 */
public class DemoTest {

    public static void main(String[] args) {
        //创建EventBus对象，并给予identifier
        //identifier：此总线的简短名称，用于日志记录。应该是一个有效的java标识符。
        EventBus eventBus = new EventBus("isiyi_event_bus");

        //注册所有的订阅
        eventBus.register(new HelloEventListener());
        eventBus.register(new Hello2EventListener());

        //发布事件
        eventBus.post(new OrderEvent("hello"));
        eventBus.post(new OrderEvent("world"));

        eventBus.post("hello world");
        eventBus.post("hello world2");

        eventBus.post(1);
        eventBus.post(12);
    }

}
