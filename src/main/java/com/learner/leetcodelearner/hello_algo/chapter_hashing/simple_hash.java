package com.learner.leetcodelearner.hello_algo.chapter_hashing;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/8/14
 */
public class simple_hash {
    /* 加法哈希 */
    public static final int MODULUS = 1000000007;
    static int addHash(String key) {
        long hash = 0;
        for (char c : key.toCharArray()) {
            hash = (hash + (int) c) % MODULUS;
        }
        return (int) hash;
    }

    /* 乘法哈希 */
    static int mulHash(String key) {
        long hash = 0;
        for (char c : key.toCharArray()) {
            hash = (31 * hash + (int) c) % MODULUS;
        }
        return (int) hash;
    }

    /* 异或哈希 */
    static int xorHash(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash ^= c;
        }
        return hash & MODULUS;
    }

    /* 旋转哈希 */
    static int rotHash(String key) {
        long hash = 0;
        for (char c : key.toCharArray()) {
            hash = ((hash << 4) ^ (hash >> 28) ^ (int)c) % MODULUS;
        }
        return (int) hash;
    }

    public static void main(String[] args) {
        String key = "Hello 算法";

        int hash = addHash(key);
        System.out.println("加法哈希值为 " + hash);

        hash = mulHash(key);
        System.out.println("乘法哈希值为 " + hash);

        hash = xorHash(key);
        System.out.println("异或哈希值为 " + hash);

        hash = rotHash(key);
        System.out.println("旋转哈希值为 " + hash);
    }

}
