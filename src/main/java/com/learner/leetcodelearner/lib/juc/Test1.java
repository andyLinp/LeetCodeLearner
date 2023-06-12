package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/9
 */
@Slf4j(topic = "c.test1")
public class Test1 {
    final static Object obj = new Object();
    // sleep(long n) 和 wait(long n) 的区别
    // 1) sleep是Thread方法  wait是Object的方法
    // 2) sleep不需要强制和 synchronized配合使用, 但wait需要和 synchronized一起用
    // 3) sleep在睡眠的同时, 不会释放对象锁, wait在等待的时候会释放对象锁
    // 4) sleep状态一般为TIMED_WAITING状态  wait状态一般为WAITING状态

    public static void main(String[] args) throws InterruptedException {
        new Thread(()-> {
            synchronized (obj) {
                log.debug("执行...");
                try {
                    obj.wait();// 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码...");
            }
        }).start();

        new Thread(()->{
            synchronized (obj) {
                log.debug("执行...");
                try {
                    obj.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码...");
            }
        }).start();

        // 主线程两秒后执行
        sleep(2);

        log.debug("唤醒 obj 上其它线程");

        synchronized (obj) {
//            obj.notify(); // 唤醒obj上一个线程
            obj.notifyAll(); // 唤醒obj上所有等待线程
        }
    }
}
