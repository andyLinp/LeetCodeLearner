package com.learner.leetcodelearner.lib;

import com.learner.leetcodelearner.lib.bean.Node;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/09/01 15:31
 **/
public class Draft {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static LinkedList<String> threadList = new LinkedList<>();
    public static void main(String[] args) throws IOException, InterruptedException {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(4);
//        list.add(5);
//        list.add(5);
//        list.add(3);
//        list.add(3);
//        list.add(2);
//
//        // 去重并降序排序
//        List<Integer> result = list.stream()
//                .distinct()
//                .sorted(Collections.reverseOrder()).collect(Collectors.toList());
//
//
//
//        System.out.println(result); // 输出 [5, 3, 2, 1]
//        result.add(6);
//        System.out.println(result); // 输出 [5, 3, 2, 1]
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 中断当前线程
//                    Thread.interrupted();
                    System.out.println("Thread is interrupted!");
                }
            }
        });

        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }






}




