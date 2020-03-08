package com.jby.mybatisTest4.dao;

import com.jby.mybatisTest4.domain.Account4;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 */
public interface IAccountDao {

    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id="accountMap",value = {  // 查询结果字段和封装类字段的映射关系，user字段使用查询以及懒加载策略
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one=@One(select="com.jby.mybatisTest4.dao.IUserDao.findById",fetchType= FetchType.EAGER)) // column 字段指明 后面One注解中select标签中的查询语句的参数类型
    })
    List<Account4> findAll();

    /**
     * 根据用户id查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid = #{userId}")
    List<Account4> findAccountByUid(Integer userId);
}
