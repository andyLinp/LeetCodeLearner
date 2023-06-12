package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 测试多任务GuardedObject的发送人
 * @Author: andy lin
 * @DATE: 2023/6/12
 */
@Slf4j(topic = "c.Postman")
public class Postman extends Thread{
    private int id;

    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        MultiGuardedObject mgo = MailBoxes.getGuardedObject(id);
        log.debug("send mail id:{}, content:{}", id, mail);
        mgo.complete(mail);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        try {
            sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Integer id : MailBoxes.getIds()) {
            new Postman(id, "content" + id).start();
        }
    }
}
