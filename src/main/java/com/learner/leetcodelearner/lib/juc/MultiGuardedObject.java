package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 多任务版本 GuardedObject
 * @Author: andy lin
 * @DATE: 2023/6/12
 */
@Slf4j(topic = "c.MultiGuardedObject")
public class MultiGuardedObject {
    // 标识 Guarded Object
    private int id;

    public MultiGuardedObject(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    // 结果
    private Object response;

    public Object get(long timeout) {
        synchronized (this) {
            long begin = System.currentTimeMillis();
            long passedTime = 0;
            while (response == null) {
                long waitTime = timeout - passedTime;
                if (waitTime <= 0) {
                    break;
                }
                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - begin;
            }
        }
        return  response;
    }


    public void complete(Object response) {
        synchronized (this) {
            this.response = response;
            this.notifyAll();
        }
    }
}
