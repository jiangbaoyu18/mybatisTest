package com.jby.MyAOPusingInterceptorchain;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Set;

public class Utils {

    public static Object wrap(final Object target, final InterceptorInterface interceptor) {
        Class<?> type = target.getClass();
        Class<?>[] interfaces = type.getInterfaces();
        if (interfaces.length > 0) {
            return Proxy.newProxyInstance(
                    type.getClassLoader(),
                    interfaces,
                    new InvocationHandler(){

                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            return interceptor.intercept(new Invocation(target, method, args));
                        }
                    });
        }
        return target;
    }
}
