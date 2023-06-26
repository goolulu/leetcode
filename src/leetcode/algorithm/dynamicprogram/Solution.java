package leetcode.algorithm.dynamicprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(Stream.of("flower", "flow", "flight").toArray(String[]::new)));
//        System.out.println(longestCommonPrefix(Stream.of("dog", "racecar", "car").toArray(String[]::new)));
//        threeSum(IntStream.of(-1, 0, 1, 2, -1, -4).toArray());
        threeSumClosest(IntStream.of(-1, 2, 1, -4).toArray(), 1);
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

    /**
     * 三数之和
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = n - 1;
            int target = -nums[i];
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    /**
     * 最接近的三数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n == 3) {
            return Arrays.stream(nums).sum();
        }
        Arrays.sort(nums);

        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = Math.abs(target - (nums[i] + nums[j]));
                int k = n - 1;
                while (j < k && Math.abs(nums[i] + nums[j] + nums[k]) < min) {
                    sum = nums[i] + nums[j] + nums[k];
                    k--;
                }
            }
        }
        return sum;
    }
}
