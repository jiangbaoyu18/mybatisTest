package com.jby.mybatisTest2.dao;


import com.jby.mybatisTest2.domain.Account2;
import com.jby.mybatisTest2.domain.AccountUser2;

import java.util.List;

/**
 */
public interface IAccountDao2 {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account2> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser2> findAllAccount();

    Account2 findAccountByUid(int uid);
}
