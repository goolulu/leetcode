package dfa;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author huangrn
 * @version 1.0
 * @date 2021/4/9 18:37
 */
public class Solution {
    /**
     * 1. 两数之和
     * @date 2021/4/9
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 26. 删除有序数组中的重复项
     *
     * @date 2021/4/9
     */

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    /**
    * @Description: 27. 移除元素
    * @Param:
    * @return:
    * @Author: huang
    * @Date: 2021/4/10
    */
    //方法一
   /* public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }*/
   //方法二
    public int removeElement(int[] nums, int val) {
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    /** 
    * @Description: 35. 搜索插入位置
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/10
    */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int key = nums.length;
        while (left <= right) {
            //这种方式能够防止溢出
            int mid = ((right-left)>>1)+left;
            if (target <= nums[mid]) {
                key = mid;
                right = mid - 1;
            } else {
                left=mid+1;
            }
        }
        return key;
    }
    /** 
    * @Description: 53. 最大子序和 
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/10-18:26
    */
    public int maxSubArray(int[] nums) {
        int pre = 0,
        max = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            max = Math.max(pre, max);
        }
        return max;
    }
    /** 
    * @Description: 66. 加一
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/11-11:11
    */
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        System.arraycopy(digits,0,result,1,digits.length);
        int jinwei = 1;
        for (int i = result.length-1; i >=0; i--) {
            if (jinwei == 1 && result[i] + 1 >= 10) {
                result[i] = (result[i]+1) % 10;
                jinwei = 1;
            } else {
                result[i] = result[i]+1;
                break;
            }
        }
        if (result[0] == 0) {
            System.arraycopy(result,1,digits,0,digits.length);
            return digits;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.plusOne(new int[]{4,3,2,1});
    }
}
