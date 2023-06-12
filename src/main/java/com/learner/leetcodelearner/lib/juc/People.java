package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 测试多任务GuardedObject的收信人
 * @Author: andy lin
 * @DATE: 2023/6/12
 */
@Slf4j(topic = "c.People")
public class People extends Thread{
    @Override
    public void run() {
        // receive mail
        MultiGuardedObject mgo = MailBoxes.createGuardedObject();
        log.debug("start receive mail. id:{}", mgo.getId());
        Object mail = mgo.get(5000);
        log.debug("received mail. id:{}, content:{}", mgo.getId(), mail);
    }
}
