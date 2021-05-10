package com.isiyi.proxy.nondp;

import com.isiyi.proxy.MetricsCollector;
import com.isiyi.proxy.RequestInfo;
import com.isiyi.proxy.UserVo;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: UserController
 * @author: 向鹏飞
 * @since: 2021/5/10
 */
public class UserController {
    //...省略其他属性和方法...
    private MetricsCollector metricsCollector; // 依赖注入
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // ... 省略login逻辑...
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
                metricsCollector.recordRequest(requestInfo);
        //...返回UserVo数据...
        return new UserVo();
    }
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // ... 省略register逻辑...
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
                metricsCollector.recordRequest(requestInfo);
        //...返回UserVo数据...
        return new UserVo();
    }
}
