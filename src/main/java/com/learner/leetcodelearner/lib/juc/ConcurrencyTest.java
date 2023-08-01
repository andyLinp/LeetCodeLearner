//package com.learner.leetcodelearner.lib.juc;
//
//import org.openjdk.jcstress.annotations.*;
//import org.openjdk.jcstress.infra.results.I_Result;
//
///**
// * @Description
// * @Author: andy lin
// * @DATE: 2023/7/5
// */
//@JCStressTest
//@Outcome(id = {"1", "4"}, expect = Expect.ACCEPTABLE, desc = "ok") // 期待的结果
//@Outcome(id = "0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "!!!!") // 不期待的结果 0是因为出现了指令重排才可能出现
//@State
//public class ConcurrencyTest {
//    int num = 0;
//    boolean ready = false;
//    @Actor
//    public void actor1(I_Result r) {
//        if (ready) {
//            r.r1 = num + num;
//        } else {
//            r.r1 = 1;
//        }
//    }
//    @Actor
//    public void actor2(I_Result r) {
//        num = 2;
//        ready = true;
//    }
//}
