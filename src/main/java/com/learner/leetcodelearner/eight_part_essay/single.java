package com.learner.leetcodelearner.eight_part_essay;

/**
 * @Description 单例模式的多种写法
 *
 * 想要实现一个单例，首先就是要考虑把构造函数设置成private的，否则的话就可以随时通过构造函数创建对象了，就不是单例了。
 *
 * 那把构造函数private之后，就还需要提供一个方法，可以初始化单例对象，并且要保证只能初始化一个单例对象。并且需要考虑线程安全的问题。
 *
 * 具体到写法上，主要有5种。分别是懒汉、饿汉、静态内部类、双重校验锁以及枚举。
 * @Author: andy lin
 * @DATE: 2023/12/5
 */
public class single {
    /**
     * 懒汉
     *      在需要的时候才会去创建对象
     *      优点:避免提前创建浪费资源
     *      缺点:第一次创建的时候浪费时间
     */
    private static single instance;

    private single(){}
    public static synchronized single getInstance() {
        if (instance == null) {
            instance = new single();
        }
        return instance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final single INSTANCE = new single();
    }

    // final 防止子类修改方法
    public final static single getInstance2() {
        return SingletonHolder.INSTANCE;
    }

}

/**
 * 饿汉
 *      在类刚开始初始化的时候就立即把单例对象创建出来
 */
class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){}

    // 方式二
    private  static Singleton instance2 = null;
    static {
        instance2 = new Singleton();
    }
    public static Singleton getInstance2(){
        return instance2;
    }
}


/**
 * 枚举类
 */
enum SingletonEnum {
    INSTANCE;
    public void whateverMethod() {

    }
}

/**
 * 双重校验锁
 */
class DoubleLockSingleton {
    private volatile static DoubleLockSingleton singleton;
    private DoubleLockSingleton (){}

    public static DoubleLockSingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleLockSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleLockSingleton();
                }
            }
        }
        return singleton;
    }
}