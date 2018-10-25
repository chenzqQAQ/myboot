/**
 * Copyright (C),2015-2018
 * FileNmae: HelloController
 * Author:   Administrator
 * Date:     2018/10/25 11:43
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.youma.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/25 11:43
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello Spring Boot!";
    }
}
