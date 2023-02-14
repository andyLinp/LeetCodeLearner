package com.learner.leetcodelearner.lib.proxy;

/**
 * JDK和CGLIB动态代理的区别: https://blog.csdn.net/qq_59527118/article/details/127386305
 * 代理模式详解: http://t.csdn.cn/113ul
 * @Description
 * @Author andy lin
 * @Date: 2023/02/14 14:25
 **/
public class Test {
    public static void main(String[] args) {
        staticProxyDemo();
        System.out.println("====================");
        dynamicProxyDemo();
    }


    private static void staticProxyDemo(){
        TeacherDao teacherDao = new TeacherDao();
        TeacherDaoProxy proxy = new TeacherDaoProxy(teacherDao);
        proxy.teach();
        System.out.println("proxy:" + proxy.getClass());
    }

    private static void dynamicProxyDemo(){
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        ITeacherDao proxyInstance = (ITeacherDao)proxyFactory.getProxyInstance();
        proxyInstance.teach();
        // com.sun.proxy.&Proxy0
        System.out.println("proxyInstance:" + proxyInstance.getClass());
    }
}
