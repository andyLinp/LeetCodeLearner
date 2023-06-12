package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/6
 */
@Slf4j(topic = "c.Test3")
public class Test3 {
    static Object lock = new Object();
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    counter++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    counter--;
                }
            }
        }, "t2");
        t1.start();
        t2.start();
        log.debug("counter:{}", counter);
    }

    private static void test3() throws InterruptedException {
        Thread t1 = new Thread(() ->{
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            // 不清除打断标记
//            log.debug("打断状态:{}", Thread.currentThread().isInterrupted());
            // 清除打断标记
            log.debug("打断状态:{}", Thread.interrupted());

            // 清除打断标记后可以重新锁住 否则只能锁住一次
            LockSupport.park();
            log.debug("unpark...");
        }, "t1");
        t1.start();

        sleep(1);

        t1.interrupt();
    }


    private static void test14() throws InterruptedException {
        Thread t1 = new Thread(()->{
           while (true) {
               if (Thread.currentThread().isInterrupted()) {
                   break;
               }
           }
           log.debug("结束");
        }, "t1");

        t1.setDaemon(true);
        t1.start();

        Thread.sleep(1000);
        log.debug("结束");

    }
}
