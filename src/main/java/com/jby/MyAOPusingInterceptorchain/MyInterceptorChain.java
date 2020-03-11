package com.jby.MyAOPusingInterceptorchain;

import org.apache.ibatis.plugin.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class MyInterceptorChain {

    private final List<InterceptorInterface> interceptors = new ArrayList<InterceptorInterface>();
    public void addInterceptor(InterceptorInterface interceptor){
        interceptors.add(interceptor);

    }

    public Object pluginAll(Object target) {
        for (InterceptorInterface interceptor : interceptors) {
            target = interceptor.plugin(target);//使用拦截器链重复对target进行增强
        }
        return target;
    }
}
