package com.nvyao.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionCounterListener implements HttpSessionAttributeListener {
    private static int activeSessions = 0;

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // 获取 ServletContext 对象
        if ("user".equals(event.getName())) { // 如果添加的属性名为"user"，表示有用户登录
            activeSessions++;
            System.out.println("User logged in. Total active sessions: " + activeSessions);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName())) { // 如果移除的属性名为"user"，表示有用户登出
            if (activeSessions > 0) {
                activeSessions--;
            }
            System.out.println("User logged out. Total active sessions: " + activeSessions);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}
