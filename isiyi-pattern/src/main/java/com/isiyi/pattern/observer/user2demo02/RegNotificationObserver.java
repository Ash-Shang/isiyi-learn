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
public class RegNotificationObserver implements RegObserver {
  //  private NotificationService notificationService;
    @Override
    public void handleRegSuccess(long userId) {
      //  notificationService.sendInboxMessage(userId, "Welcome...");
    }
}
