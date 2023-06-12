package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/5
 */
@Slf4j(topic = "c.TestFrames")
public class TestFrames {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    private static void method1(int x) {
        int y = x + 1;
        Object m = method2();
        System.out.println(m);
    }

    private static Object method2() {
        Object n = new Object();
        return n;
    }

    public static void test1(){
        Runnable task1 = () -> {
            int count = 0;
            for (;;) {
                System.out.println("----->1" + count++);
            }
        };

        Runnable task2 = ()->{
            int count = 0;
            for (;;) {
                System.out.println("----->2" + count++);
            }
        };

        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
    static int r1 = 0;
    static int r2 = 0;
    public static void test2() throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r1 = 10;
        });

        long start = System.currentTimeMillis();
        t1.start();

        log.debug("join begin");
        t1.join(1500);
        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);

    }


    // 打断阻塞状态的线程
    // 阻塞状态的线程 可以被 interrupt方法打断  sleep/wait/join 状态被打断后 打断标记为false
    // 正常运行的线程被打断后 打断标记为true
    // 通过线程的 isInterrupted() 方法查看是否被打断
    public static void test3() throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("sleep...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        log.debug("interrupt");

        t1.interrupt();
        log.debug("打断标记:{}", t1.isInterrupted());
    }

    // 打断正常执行的线程
    public static void test4() throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    log.debug("打断状态:{}", Thread.currentThread().isInterrupted());
                    break;
                }

            }}, "t1");
        t1.start();

        Thread.sleep(1000);
        log.debug("interrupt");
        t1.interrupt();
    }

    // 模式之 两阶段终止模式 Two Phase Termination
    // Runnable 运行/可运行/阻塞
    // new
    // Blocked
    // Waiting
    // Timed_Waiting
    // Terminated


}
