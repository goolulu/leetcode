package leetcode;

import java.util.*;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
                while (!queue.isEmpty() && queue.peek().position == -1) {
                    queue.poll();
                }
            } else {
                map.put(c, i);
                queue.offer(new Pair(i, c));
            }
        }
        return queue.isEmpty() ? ' ' : queue.poll().c;

    }

    static class Pair {
        public int position;
        public char c;

        public Pair(int position, char c) {
            this.position = position;
            this.c = c;
        }
    }
}
