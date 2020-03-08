package com.jby.mybatisTest2.dao;

import com.jby.mybatisTest2.domain.User2;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao2 {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User2> findAll();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User2 findById(Integer userId);


}
