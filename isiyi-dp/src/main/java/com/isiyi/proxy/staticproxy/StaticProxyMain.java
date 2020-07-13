package com.isiyi.proxy.staticproxy;

import com.isiyi.proxy.staticproxy.impl.LDHStar;
import com.isiyi.proxy.staticproxy.inters.Star;
import com.isiyi.proxy.staticproxy.proxy.ProxyManger;

public class StaticProxyMain {

    public static void main(String[] args) {
        // 创建明星对象
        Star ldh = new LDHStar();
        ProxyManger proxy = new ProxyManger(ldh);
        proxy.sing();
    }

    /**
     * 优点：可以做到在不修改目标对象的功能前提下,对目标功能扩展.
     * 缺点:因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.
     *     同时,一旦接口增加方法,目标对象与代理对象都要维护.
     */
}
