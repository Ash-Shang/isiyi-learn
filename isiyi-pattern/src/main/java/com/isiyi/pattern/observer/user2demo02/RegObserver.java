package com.isiyi.pattern.observer.user2demo02;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: 类描述
 * @author: siyi
 * @since: 2021/4/24
 */
public interface RegObserver {
    /**
     *
     * @param userId
     */
    void handleRegSuccess(long userId);
}
