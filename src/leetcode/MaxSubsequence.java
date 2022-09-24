package leetcode;

public class MaxSubsequence {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ret = new int[k];
        int minIndex = 0;
        int min = nums[0];

        for (int i = 0; i < k; i++) {
            ret[i] = nums[i];
            if (nums[i] <= min) {
                min = nums[i];
                minIndex = i;
            }
        }
        return new int[1];
    }



    public static void main(String[] args) {
        MaxSubsequence maxSubsequence = new MaxSubsequence();
        maxSubsequence.maxSubsequence(new int[]{2,1,3,3}, 2);
    }
}
