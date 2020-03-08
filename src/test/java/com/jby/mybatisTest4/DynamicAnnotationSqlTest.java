package com.jby.mybatisTest4;

import com.jby.mybatisTest1.domain.QueryVo;
import com.jby.mybatisTest4.dao.IAccountDao;
import com.jby.mybatisTest4.dao.IUserDao;
import com.jby.mybatisTest4.domain.Account4;
import com.jby.mybatisTest4.domain.User4;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import com.jby.mybatisTest4.domain.Account4;
import com.jby.mybatisTest4.dao.IAccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class DynamicAnnotationSqlTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindUserByIds(){
        QueryVo queryVo = new QueryVo();
        ArrayList list = new ArrayList<Integer>();
        list.add(46);
        list.add(49);
        list.add(50);
        queryVo.setIds(list);
        List<User4> users = userDao.findUserInIds(queryVo);
        for(User4 user : users){
            System.out.println(user);
        }
    }



}

