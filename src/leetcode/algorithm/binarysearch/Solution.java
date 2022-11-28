package leetcode.algorithm.binarysearch;

import java.util.*;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int l1 = 0, l2 = 0;
        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] == nums2[l2]) {
                set.add(nums1[l1]);
                l1++;
                l2++;
            } else if (nums1[l1] < nums2[l2]) {
                l1++;
            } else if (nums1[l1] > nums2[l2]) {
                l2++;
            }
        }

        return set.stream().mapToInt(i -> i).toArray();
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int l1 = 0, l2 = 0;
        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] == nums2[l2]) {
                list.add(nums1[l1]);
                l1++;
                l2++;
            } else if (nums1[l1] < nums2[l2]) {
                l1++;
            } else if (nums1[l1] > nums2[l2]) {
                l2++;
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        int nums1[] = new int[]{1, 2, 2, 1};
        int nums2[] = new int[]{2, 2};
        Solution s = new Solution();
        s.intersection(nums1, nums2);
    }
}
