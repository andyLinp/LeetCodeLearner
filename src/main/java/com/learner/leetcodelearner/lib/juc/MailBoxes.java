package com.learner.leetcodelearner.lib.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @Description 多任务GuardedObject的中间解耦类
 * @Author: andy lin
 * @DATE: 2023/6/12
 */
@Slf4j(topic = "c.MailBoxes")
public class MailBoxes {
    private static Map<Integer, MultiGuardedObject> boxes = new Hashtable<>();

    private static int id = 1;

    private static synchronized int generatedId() {
        return id++;
    }

    public static MultiGuardedObject getGuardedObject(int id) {
        return boxes.remove(id);
    }

    public static MultiGuardedObject createGuardedObject() {
        MultiGuardedObject mgo = new MultiGuardedObject(generatedId());
        boxes.put(mgo.getId(), mgo);
        return mgo;
    }


    public static Set<Integer> getIds() {
        return boxes.keySet();
    }

}
