package com.youma.dao;

import com.youma.vo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * UserDao
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/25 13:32
 */
@Mapper
public interface UserDao {
    @Select("select userID,userName,userPassword from users")
    public List<Users> userList();
    public int userAdd(Users users);
}

