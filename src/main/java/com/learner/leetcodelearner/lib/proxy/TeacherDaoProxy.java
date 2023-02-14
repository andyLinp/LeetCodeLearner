package com.learner.leetcodelearner.lib.proxy;

/**
 * @Description static proxy, proxy object
 * @Author andy lin
 * @Date: 2023/02/14 14:06
 **/
public class TeacherDaoProxy implements ITeacherDao {
    // target object
    private ITeacherDao target;
    // constructor
    public TeacherDaoProxy(ITeacherDao target){
        this.target = target;
    }
    @Override
    public void teach() {
        System.out.println("as agent begins");
        target.teach();
        System.out.println("as agent ends");
    }
}
