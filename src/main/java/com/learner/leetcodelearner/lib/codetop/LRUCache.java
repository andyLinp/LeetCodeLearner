package com.learner.leetcodelearner.lib.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description  LRU 缓存
 * @Author andy lin
 * @Date: 2023/01/03 10:18
 **/
public class LRUCache {
    /**
     * 双向链表
     */
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    /**
     * 缓存
     */
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    /**
     * 已使用
     */
    private int size;
    /**
     * 最大容纳
     */
    private int capacity;
    /**
     * 头节点
     * 尾结点
     */
    private DLinkedNode head, tail;

    /**
     * 构造
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 取
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果key存在,先通过哈希表定位,再移到头部
        moveToHead(node);
        return node.value;
    }

    /**
     * 放
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在,则创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量,删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中的对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在, 先通过哈希表定位, 再修改value,并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 作为头节点
     * @param node
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 移除节点
     * @param node
     */
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 移动节点为头节点
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 移除尾部节点
     * @return
     */
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
