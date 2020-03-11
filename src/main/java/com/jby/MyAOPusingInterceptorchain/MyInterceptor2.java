package com.jby.MyAOPusingInterceptorchain;

import org.apache.ibatis.plugin.Invocation;

import java.lang.reflect.Method;

public class MyInterceptor2 implements InterceptorInterface{

    public Object intercept(Invocation invocation) throws Throwable{

        System.out.println("my intercept 2 before");
        Object target = invocation.getTarget();
        Method method = invocation.getMethod();
        Object[] args = invocation.getArgs();
        Object result = method.invoke(target,args);
        System.out.println("my intercept 2 after");
        return result;
    }

    public Object plugin(Object target){
        return Utils.wrap(target,this);
    }
}
