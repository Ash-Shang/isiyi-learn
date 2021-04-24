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
public class RegPromotionObserver implements  RegObserver{

    //private PromotionService promotionService; // 依赖注入

    @Override
    public void handleRegSuccess(long userId) {
      //  promotionService.issueNewUserExperienceCash(userId);
    }
}
