package com.learner.leetcodelearner.hello_algo.chapter_array_linkedlist;

import java.util.Arrays;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/8/4
 */
public class my_list {
    /* Driver Code */
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        System.out.println("列表 list = " + Arrays.toString(list.toArray()) + ", 容量 = " + list.capacity() + ", 长度 = " + list.size());
        /* 中间插入元素 */
        list.insert(3, 6);
        System.out.println("在索引 3 处插入数字 6 ，得到 list = " + Arrays.toString(list.toArray()));

        /* 删除元素 */
        list.remove(3);
        System.out.println("删除索引 3 处的元素，得到 list = " + Arrays.toString(list.toArray()));

        /* 访问元素 */
        int num = list.get(1);
        System.out.println("访问索引 1 处的元素，得到 num = " + num);

        /* 更新元素 */
        list.set(1, 0);
        System.out.println("将索引 1 处的元素更新为 0 ，得到 list = " + Arrays.toString(list.toArray()));

        /* 测试扩容机制 */
        for (int i = 0; i < 10; i++) {
            // 在 i = 5 时，列表长度将超出列表容量，此时触发扩容机制
            list.add(i);
        }
        System.out.println("扩容后的列表 list = " + Arrays.toString(list.toArray()) +
                " ，容量 = " + list.capacity() + " ，长度 = " + list.size());

    }
}
