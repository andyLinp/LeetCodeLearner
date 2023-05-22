package com.learner.leetcodelearner.lib.bean.v17;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/05/18 16:06
 **/
public non-sealed class Pear extends Fruit{

    public void print(){
        System.out.println(super.getName() + "-" + super.getPrice());
    }
}
