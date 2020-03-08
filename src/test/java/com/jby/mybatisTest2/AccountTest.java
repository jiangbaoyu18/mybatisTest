package com.jby.mybatisTest2;

import com.jby.mybatisTest2.dao.IAccountDao2;
import com.jby.mybatisTest2.domain.Account2;
import com.jby.mybatisTest2.domain.AccountUser2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * test many to one
 */
public class AccountTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao2 accountDao2;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        accountDao2 = sqlSession.getMapper(IAccountDao2.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<Account2> accounts = accountDao2.findAll();
        for(Account2 account : accounts){
            System.out.println(account.getId()+":"+account.getMoney());// not trigger lazy load
//            System.out.println("--------每个account的信息------------");
//            System.out.println(account);
//            System.out.println(account.getUser());
        }
    }


    /**
     * 测试查询所有账户，同时包含用户名称和地址
     */
    @Test
    public void testFindAllAccountUser(){
        List<AccountUser2> aus = accountDao2.findAllAccount();
        for(AccountUser2 au : aus){
            System.out.println(au);
        }
    }
}
