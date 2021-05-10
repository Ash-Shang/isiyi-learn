package com.isiyi.proxy.staticproxy;

import com.isiyi.proxy.UserVo;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: IUserController
 * @author: 向鹏飞
 * @since: 2021/5/10
 */
public interface IUserController {

    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);

}
