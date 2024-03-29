package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 交替输出
 * 线程1输出a5次 线程2输出b5次 线程3输出c5次
 * 现在要求输出 abcabcabcabcabc
 * @Author: andy lin
 * @DATE: 2023/6/13
 */
@Slf4j(topic = "c.OutputABCTest")
public class OutputABCTest {

    public static void main(String[] args) {
//        SyncWaitNotify syncWaitNotify = new SyncWaitNotify(1, 5);
//        new Thread(()-> syncWaitNotify.print(1, 2, "a")).start();
//
//        new Thread(()-> syncWaitNotify.print(2, 3, "b")).start();
//
//        new Thread(()-> syncWaitNotify.print(3, 1, "c")).start();

//        AwaitSignal as = new AwaitSignal(5);
//        Condition a = as.newCondition();
//        Condition b = as.newCondition();
//        Condition c = as.newCondition();
//
//        new Thread(()-> as.print("a1", a, b)).start();
//
//        new Thread(()-> as.print("b1", b, c)).start();
//
//        new Thread(()-> as.print("c1", c, a)).start();
//
//        as.start(a);

        SyncPark syncPark = new SyncPark(5);
        Thread t1 = new Thread(() -> syncPark.print("a"));
        Thread t2 = new Thread(() -> syncPark.print("b"));
        Thread t3 = new Thread(() -> syncPark.print("c\n"));
        syncPark.setThreads(t1,t2,t3);
        syncPark.start();
    }
}
@Slf4j(topic = "c.SyncWaitNotify")
class SyncWaitNotify{
    /**
     * 标识
     */
    private int flag;
    /**
     * 循环次数
     */
    private int loopNumber;

    public SyncWaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(int waitFlag, int nextFlag, String str) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while(this.flag != waitFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

}

@Slf4j(topic = "c.AwaitSignal")
class AwaitSignal extends ReentrantLock {
    private int loopNumber;

    public AwaitSignal (int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void start(Condition first) {
        this.lock();
        try {
            log.debug("start");
            first.signal();
        } finally {
          this.unlock();
        }
    }

    public void print(String str, Condition current, Condition next) {
        for (int i = 0; i < loopNumber; i++) {
            this.lock();
            try {
                current.await();
                log.debug(str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }
        }
    }



}

@Slf4j(topic = "c.SyncPark")
class SyncPark {
    private int loopNumber;

    private Thread[] threads;

    public SyncPark(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void setThreads(Thread ... threads) {
        this.threads = threads;
    }

    public void print(String str) {
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(nextThread());
        }
    }

    private Thread nextThread() {
        Thread current = Thread.currentThread();
        int index = 0;
        for (int i = 0; i < threads.length; i++) {
            if (threads[i] == current) {
                index = i;
                break;
            }
        }
        if (index < threads.length - 1) {
            return threads[index + 1];
        } else {
            return threads[0];
        }
    }

    public void start() {
        for (Thread thread : threads) {
            thread.start();
        }
        LockSupport.unpark(threads[0]);
    }
}
