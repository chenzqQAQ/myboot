/**
 * Copyright (C),2015-2018
 * FileNmae: Users
 * Author:   Administrator
 * Date:     2018/10/25 13:30
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.youma.vo;

/**
 * Users
 * 用户实体类
 *
 * @author 陈泽群
 * @date 2018/10/25 13:30
 */
public class Users {
    /**
     * 用户id
     */
    private int userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
