package com.jby.MyAOPusingInterceptorchain;

import org.apache.ibatis.plugin.Invocation;

public interface InterceptorInterface {

    Object intercept(Invocation invocation) throws Throwable;
    Object plugin(Object target);
}
