package com.isiyi.proxy.dynamicsproxy;

import com.isiyi.proxy.nondp.UserController;
import com.isiyi.proxy.staticproxy.IUserController;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: DynamicsTest
 * @author: 向鹏飞
 * @since: 2021/5/10
 */
public class DynamicsTest {

    public void test01(){
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());

    }

}
