package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 监控线程 同步之Balking(犹豫)模式
 * @Author: andy lin
 * @DATE: 2023/7/3
 */
@Slf4j(topic = "lp.Monitor")
public class MonitorService {
    private volatile boolean starting;

    public void start() {
        log.info("trying start monitor");
        synchronized (this) {
            if (starting) {
                return;
            }
            starting = true;
        }
        // real start monitor thread ...
    }
}
