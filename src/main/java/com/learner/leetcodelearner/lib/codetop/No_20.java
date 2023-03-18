package com.learner.leetcodelearner.lib.codetop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/03/14 15:04
 **/
public class No_20 {

        private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
            put('{','}'); put('[',']'); put('(',')'); put('?','?');
        }};


        private boolean isValid(String s) {
            if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
            LinkedList<Character> stack = new LinkedList<Character>(){{add('?');}};
            for (Character c : s.toCharArray()) {
                if (map.containsKey(c)) stack.addLast(c);
                else if (map.get(stack.removeLast()) != c) return false;
            }
            return stack.size() == 1;
        }

}
