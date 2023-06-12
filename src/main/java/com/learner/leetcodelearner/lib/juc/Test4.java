package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Thread.sleep;

/**
 * @Description 两阶段终止模式
 * @Author: andy lin
 * @DATE: 2023/6/6
 */
@Slf4j(topic = "c.Test4")
public class Test4 {

    public static void main(String[] args) throws InterruptedException {


        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();

        Thread.sleep(3500);
        tpt.stop();
    }
}

@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTermination {
    private Thread monitor;

    /**
     * 启动监控线程
     */
    public void start() {
        monitor = new Thread(()->{
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.debug("被打断后,料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);// 情况1 被打断
                    log.debug("执行监控记录"); // 情况2 被打断
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 重新设置打断标识
                    Thread.currentThread().interrupt();
                }

            }
        });
        monitor.start();
    }

    /**
     * 停止监控线程
     */
    public void stop() {
        monitor.interrupt();
    }
}
