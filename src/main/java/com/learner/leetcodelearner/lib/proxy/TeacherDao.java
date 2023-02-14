package com.learner.leetcodelearner.lib.proxy;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/02/14 14:06
 **/
public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("teaching...");
    }
}
