/**
 * Copyright (C),2015-2018
 * FileNmae: userServiceImpl
 * Author:   Administrator
 * Date:     2018/10/25 14:09
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.youma.service.impl;

import com.youma.dao.UserDao;
import com.youma.service.userService;
import com.youma.vo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * userServiceImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/25 14:09
 */
@Service
public class userServiceImpl implements userService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Users> usersList() {
        return userDao.userList();
    }
}
