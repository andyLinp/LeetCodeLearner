package com.learner.leetcodelearner.lib.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description dynamic proxy
 * @Author andy lin
 * @Date: 2023/02/14 14:17
 **/
public class ProxyFactory {
    // target object
    private Object target;

    // constructor init
    public ProxyFactory(Object target) {
        this.target = target;
    }
    // generate a proxy object for the target object
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK proxy start >>>");
                // the reflection mechanism calls methods on the target object
                Object returnVal = method.invoke(target, args);
                System.out.println("JDK proxy ends >>>");
                return returnVal;
            }
        });

    }

}
