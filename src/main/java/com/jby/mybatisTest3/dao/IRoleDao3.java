package com.jby.mybatisTest3.dao;

import com.jby.mybatisTest3.domain.Role3;

import java.util.List;

/**
 */
public interface IRoleDao3 {

    /**
     * 查询所有角色
     * @return
     */
    List<Role3> findAll();
}
