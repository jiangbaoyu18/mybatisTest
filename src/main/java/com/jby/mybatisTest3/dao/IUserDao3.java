package com.jby.mybatisTest3.dao;

import com.jby.mybatisTest3.domain.User3;

import java.util.List;

/**
 *
 * 用户的持久层接口
 */
public interface IUserDao3 {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User3> findAll();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User3 findById(Integer userId);


}
