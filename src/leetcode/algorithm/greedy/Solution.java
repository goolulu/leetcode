package leetcode.algorithm.greedy;

import java.util.*;

public class Solution {
    /**
     * 409. 最长回文串
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            count++;
            if (count % 2 == 0) {
                count = 0;
                total += 2;
            }
            map.put(c, count);
        }
        if (map.containsValue(1)) {
            total++;
        }
        return total;
    }

    /**
     * 455. 分发饼干
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j = 0;
        for (int k : g) {
            while (j < s.length) {
                if (k > s[j]) {
                    j++;
                } else {
                    count++;
                    j++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 605. 种花问题
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && i == 0) {
                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }

            if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
                    flowerbed[i] = 1;
                    count++;
                }
            }

            if (i == flowerbed.length - 1 && flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1, j = nums.length - 2, k = nums.length - 3;

        if (nums[j] + nums[k] > nums[i]) {
            return nums[j] + nums[k] + nums[i];
        } else {
            return 0;
        }
    }

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        if (cost.length <= 2) {
            return Arrays.stream(cost).sum();
        }
        int totalCost = 0;
        int i = cost.length-1;
        while (i >= 0) {
            totalCost += cost[i];
            if (i - 1 >= 0) {
                totalCost += cost[i--];
            }
            i=i-2;
        }
        return totalCost;
    }
    public int minTimeToType(String word) {
        int total = 0;
        int pre = 0;
        for (char ch : word.toCharArray()) {
            int curr = ch - 'a';
            total += 1 + Math.min(Math.abs(curr - pre), 26 - Math.abs(curr - pre));
            pre = curr;
        }
        return total;
    }

    public int minimumSum(int num) {
        String numStr = Integer.toString(num);
        char[] characters = numStr.toCharArray();
        Arrays.sort(characters);

        return 10 * (Character.getNumericValue(characters[0]) + Character.getNumericValue(characters[1])) + Character.getNumericValue(characters[2]) + Character.getNumericValue(characters[3]);

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> list = new HashSet<>();
        for (int j = 0; j < nums2.length; j++) {
            if(set.contains(nums2[j])){
                list.add(nums2[j]);
            }
        }
        int[] a = new int[0];

        return list.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.longestPalindrome("abccccdd"));

       // System.out.println(s.minTimeToType("abc"));
//        System.out.println(s.minTimeToType("bza"));
//        System.out.println(s.minTimeToType("zjpc"));
        System.out.println(s.minimumCost(new int[]{3,3,3,1}));

    }
}
