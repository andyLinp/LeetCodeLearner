package com.learner.leetcodelearner.lib.utils;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/04/07 14:28
 **/
import java.util.Comparator;

public class WindowsFileNameComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        // 比较文件夹和文件
//        boolean isDir1 = (s1.charAt(s1.length() - 1) == '\\');
//        boolean isDir2 = (s2.charAt(s2.length() - 1) == '\\');
//        if (isDir1 && !isDir2) {
//            return -1;
//        } else if (!isDir1 && isDir2) {
//            return 1;
//        }

        // 分别比较字符串中的数字、字母和点号
        int i1 = 0, i2 = 0;
        while (i1 < s1.length() && i2 < s2.length()) {
            char c1 = s1.charAt(i1), c2 = s2.charAt(i2);
            if (Character.isDigit(c1) && Character.isDigit(c2)) {
                int num1 = 0, num2 = 0;
                while (i1 < s1.length() && Character.isDigit(s1.charAt(i1))) {
                    num1 = num1 * 10 + (s1.charAt(i1) - '0');
                    i1++;
                }
                while (i2 < s2.length() && Character.isDigit(s2.charAt(i2))) {
                    num2 = num2 * 10 + (s2.charAt(i2) - '0');
                    i2++;
                }
                if (num1 != num2) {
                    return Integer.compare(num1, num2);
                }
            } else if (c1 == c2) {
                i1++;
                i2++;
            } else if (c1 == '.' || c2 == '.') {
                // 点号比字母小，但比数字大
                if (c1 == '.') {
                    return -1;
                } else if (c2 == '.') {
                    return 1;
                } else {
                    return Character.compare(c1, c2);
                }
            } else {
                return Character.compare(Character.toLowerCase(c1), Character.toLowerCase(c2));
            }
        }

        // 如果字符串的前缀相同，则长度较短的字符串排在前面
        return Integer.compare(s1.length(), s2.length());
    }
}

