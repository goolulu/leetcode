package leetcode.algorithm.dynamicprogram;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babc"));
        System.out.println(longestPalindromeDp("babc"));
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

}
