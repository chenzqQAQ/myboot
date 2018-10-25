/**
 * Copyright (C),2015-2018
 * FileNmae: userAction
 * Author:   Administrator
 * Date:     2018/10/25 13:34
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.youma.action;

import com.youma.service.userService;
import com.youma.vo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * userAction
 * 用户控制类
 *
 * @author 陈泽群
 * @date 2018/10/25 13:34
 */
@Controller
public class userAction {


    private userService userService;

    public com.youma.service.userService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(com.youma.service.userService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String userList(Model model) {
        System.out.println("进入全查咯");
        List<Users> list = userService.usersList();
        if (list == null) {
            System.out.println("咋是空的呢");
        } else {
            list.stream().forEach((x) -> System.out.println(x.getUserName() + " " + x.getUserPassword()));
        }
        model.addAttribute("users", list);
        return "user";
    }
}
