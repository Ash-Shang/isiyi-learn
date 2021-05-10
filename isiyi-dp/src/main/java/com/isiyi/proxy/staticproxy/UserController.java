package com.isiyi.proxy.staticproxy;

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
public class UserController implements IUserController{
    @Override
    public UserVo login(String telephone, String password) {
        // 登录业务
        return new UserVo();
    }

    @Override
    public UserVo register(String telephone, String password) {
        // 注册业务
        return new UserVo();
    }
}
