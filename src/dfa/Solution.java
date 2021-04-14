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
    * @Description: 53. 最大子序和 贪心算法
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
    /*public int[] plusOne(int[] digits) {
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
    }*/
    //方法二
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;

        }
        return digits;

    }
    /** 
    * @Description: 88. 合并两个有序数组
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/11-12:00
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = 0;
        int n2 = 0;
        int  cur = 0;
        int[] result = new int[nums1.length];
        while (n1 < m || n2 < n) {
            if (n1 == m) {
                cur = nums2[n2++];
            } else if (n2 == n) {
                cur = nums1[n1++];
            } else if (nums1[n1] < nums2[n2]) {
                cur = nums1[n1++];
            } else {
                cur = nums2[n2++];
            }
            result[n1+n2-1] = cur;
        }
        System.arraycopy(result,0,nums1,0,nums1.length);

    }
    /** 
    * @Description: 118. 杨辉三角。
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/11-16:02
    */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row  = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    //等于上一行的前一个加上一行对应index
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    /** 
    * @Description: 119. 杨辉三角 II 相比上一道题只需要求出保存前一行数组就可以了
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/11-16:09
    */
    /*public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row  = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    //滚动数组
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre=row;
        }
        return pre;
    }*/
    //方法二
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
    /** 
    * @Description: 121. 买卖股票的最佳时机,贪心算法
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/11-16:54
    */

    public int maxProfit(int[] prices) {
        int sum = 0;
        int cur = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > cur) {
                if (prices[i] - cur > sum) {
                    sum = prices[i] - cur;
                }
            } else if (prices[i] < cur) {
                cur = prices[i];
            }
        }
        return sum;
    }
    /** 
    * @Description: 167. 两数之和 II - 输入有序数组
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/11-17:02
    */
    /*public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i+1;
                result[0] = map.get(target - numbers[i])+1;
            } else {
                map.put(numbers[i], i);
            }
        }
        return result;
    }*/
    //二分法
    public int[] twoSum1(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int left =i+1;
            int right = numbers.length-1;
            while (left <= right) {
                int mid = ((right-left)>>2)+left;
                if (target - numbers[i] > numbers[mid]) {
                    left=mid+1;
                } else if (target - numbers[i] == numbers[mid]) {
                    return new int[]{i, mid};
                } else {
                    right = mid-1;
                }
            }
        }
        return new int[]{-1,-1};
    }
    /**
    * @Description: 122. 买卖股票的最佳时机 II
    * @Param:
    * @return:
    * @Author: huang
    * @Date: 2021/4/12-8:44
    */

    public int maxProfit1(int[] prices) {
        int key = Integer.MAX_VALUE;
        int sum = 0;
        int max = 0;
        int i =0;
        while (i < prices.length) {
            if (prices[i] < key) {
                key = prices[i];
            } else if (prices[i] > key) {
                sum += prices[i] - key;
                key = prices[i];
            }
            i++;
        }
        return  sum;
    }
    /**
     * @Description: 169. 多数元素
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/14-22:24
     */
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int major = nums.length/2+1;
        return nums[major];
    }*/
    //方法二
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    major = nums[i];
                    count=1;
                }
            }
        }
        return major;
    }
    
    /** 
    * @Description: 217. 存在重复元素
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/14-22:31
    */
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result = true;
                break;
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        return result;
    }
    

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.containsDuplicate(new int[]{1,2,3,4});
    }
}
