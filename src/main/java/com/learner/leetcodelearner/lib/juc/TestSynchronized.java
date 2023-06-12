package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/7
 */
@Slf4j(topic = "c.Sync")
public class TestSynchronized {

    public static void main(String[] args) throws InterruptedException {
        sleep(1);
    }
}

@Slf4j(topic = "c.Number1")
class Number1 {
    public synchronized void a() {
        log.debug("1");
    }

    public synchronized void b() {
        log.debug("2");
    }
}

@Slf4j(topic = "c.Number2")
class Number2 {
    public synchronized void a() throws InterruptedException {
        sleep(1);
        log.debug("1");
    }

    public synchronized void b() {
        log.debug("2");
    }
}
