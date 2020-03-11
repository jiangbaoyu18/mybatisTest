package com.jby.mybatisTest4.dao;

import com.jby.mybatisTest1.domain.QueryVo;
import com.jby.mybatisTest4.domain.User4;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在mybatis中针对,CRUD一共有四个注解
 *  @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)//mybatis 基于注解方式实现配置二级缓存
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.jby.mybatisTest4.dao.IAccountDao.findAccountByUid",
                                fetchType = FetchType.LAZY))
    })
    List<User4> findAll();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{id} ")
    @ResultMap("userMap")  // 引用前面定义的ResultMap
    User4 findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username} ")
    @ResultMap("userMap")
    List<User4> findUserByName(String username);


    // 在注解中使用动态sql
    @Select("<script> " +
            "select * from user where id in ( " +
            "<if test='ids != null and ids.size()>0'>" +
                "<foreach collection='ids' open='' close='' item='uid' separator=','>" +
                     " #{uid}" +
                 "</foreach>" +

            "</if>" +
            " )" +
            "</script>" )
    @ResultMap("userMap")
    List<User4> findUserInIds( QueryVo queryvo);


}
