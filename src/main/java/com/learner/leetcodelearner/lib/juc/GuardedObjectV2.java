package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 带超时版GuardedObject
 * @Author: andy lin
 * @DATE: 2023/6/12
 */
@Slf4j(topic = "c.GuardedObjectV2")
public class GuardedObjectV2 {
    private Object response;

    private final Object lock = new Object();

    public Object get(long mills) {
        synchronized(lock) {
            // 1. start time
            long begin = System.currentTimeMillis();
            // 2. passed time
            long timePassed = 0;
            while (response == null) {
                // 4. wait time
                long waitTime = mills - timePassed;
                log.debug("waitTime: {}", waitTime);
                if (waitTime <= 0) {
                    log.debug("breaking...");
                    break;
                }

                try {
                    lock.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 3. notifyed
                timePassed = System.currentTimeMillis() - begin;
                log.debug("timePassed:{}, object is null {}", timePassed, response == null);
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (lock) {
            this.response = response;
            log.debug("notify...");
            lock.notifyAll();
        }
    }
}
