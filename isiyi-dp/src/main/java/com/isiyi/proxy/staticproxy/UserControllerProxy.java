package com.isiyi.proxy.staticproxy;

import com.isiyi.proxy.MetricsCollector;
import com.isiyi.proxy.RequestInfo;
import com.isiyi.proxy.UserVo;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: UserControllerProxy
 * @author: 向鹏飞
 * @since: 2021/5/10
 */
public class UserControllerProxy implements IUserController {
    private MetricsCollector metricsCollector;
    private UserController userController;
    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }
    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // 委托
        UserVo userVo = userController.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
                metricsCollector.recordRequest(requestInfo);
        return userVo;
    }
    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = userController.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime,  startTimestamp);
                metricsCollector.recordRequest(requestInfo);
        return userVo;
    }
}
