package leetcode.algorithm.dynamicprogram;

import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(Stream.of("flower", "flow", "flight").toArray(String[]::new)));
        System.out.println(longestCommonPrefix(Stream.of("dog", "racecar", "car").toArray(String[]::new)));
    }


    /**
     * 最长回文子串 暴力
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int begin = 0;
        int max = 1;
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > max && valiadPalindrome(i, j, s)) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    /**
     * 判断是否为字符串
     *
     * @param i
     * @param j
     * @param s
     * @return
     */
    private static boolean valiadPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;

    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    private static String longestPalindromeDp(String s) {
        if (s.length() < 2) {
            return s;
        }
        int begin = 0;
        int max = 1;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else if (j - i < 3 || dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        begin = i;
                    }
                }

            }
        }
        return s.substring(begin, begin + max);
    }

    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 1) {
            return strs[0];
        }

        String commonPrefix = strs[0];
        for (int i = 1; i < len; i++) {

            String curr = strs[i];
            int minLen = Math.min(commonPrefix.length(), curr.length());
            String newC = "";
            for (int j = 0; j < minLen; j++) {
                char currChar = curr.charAt(j);
                char commonChar = commonPrefix.charAt(j);
                if (currChar == commonChar) {
                    newC = newC + currChar;
                } else {
                    break;
                }
            }
            commonPrefix = newC;
        }
        return commonPrefix;
    }


}
