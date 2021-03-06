package leetcode;

import java.util.*;

/**
 * @author huangrn
 * @version 1.0
 * @date 2021/4/9 18:37
 */
public class Solution {
    /**
     * 1. 两数之和
     *
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
        return i + 1;
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
        int i = 0;
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
        int right = nums.length - 1;
        int key = nums.length;
        while (left <= right) {
            //这种方式能够防止溢出
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                key = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
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
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
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
        int cur = 0;
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
            result[n1 + n2 - 1] = cur;
        }
        System.arraycopy(result, 0, nums1, 0, nums1.length);

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
            List<Integer> row = new ArrayList<>();
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
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = ((right - left) >> 2) + left;
                if (target - numbers[i] > numbers[mid]) {
                    left = mid + 1;
                } else if (target - numbers[i] == numbers[mid]) {
                    return new int[]{i, mid};
                } else {
                    right = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
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
        int i = 0;
        while (i < prices.length) {
            if (prices[i] < key) {
                key = prices[i];
            } else if (prices[i] > key) {
                sum += prices[i] - key;
                key = prices[i];
            }
            i++;
        }
        return sum;
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
                    count = 1;
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

    /**
     * @Description: 219. 存在重复元素 II
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/14-23:40
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) {

                    result = true;
                    break;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    /**
     * @Description: 228. 汇总区间 没做出来
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/15-7:35
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int left = i;
            i++;
            while (i < nums.length && nums[i] - 1 == nums[i - 1]) {
                i++;
            }
            int right = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[left]));
            if (left < right) {
                temp.append("->");
                temp.append(nums[right]);
            }
            list.add(temp.toString());
        }
        return list;
    }

    /**
     * @Description: 268. 丢失的数字
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/15-10:50
     */
    public int missingNumber(int[] nums) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            sum2 += nums[i];
        }
        return sum + nums.length - sum2;

    }


    /**
     * @Description: 283. 移动零
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/15-13:04
     */
    //自己写的
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                i = k;
                break;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0 && k > i) {
                j = k;
                break;
            }
        }
        while (j < nums.length) {
            if (nums[i] == 0 && nums[j] != 0 && j > i) {
                int temp = nums[j];
                nums[i] = temp;
                nums[j] = 0;
                j = i;
                i = j + 1;
            } else {
                j++;
            }
        }
    }
    //官方
    /*public void moveZeroes(int[] nums) {
        int i =0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] =nums[i];
                nums[i] = temp;
                i++;
            }
            j++;
        }
        System.out.println("ok");
    }*/

    /**
     * @Description: 414. 第三大的数
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/15-16:50
     */
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3);
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < 3 && !priorityQueue.contains(nums[i])) {
                priorityQueue.offer(nums[i]);
            } else if (priorityQueue.peek() < nums[i] && !priorityQueue.contains(nums[i])) {
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        if (priorityQueue.size() < 3) {
            for (int i = 0; i < priorityQueue.size() - 1; i++) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    /**
     * @Description: 448. 找到所有数组中消失的数字
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/15-23:42
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }

    //官方方法
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = (nums[i] - 1) % nums.length;
            nums[x] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                list.add(i + 1);
            }
        }
        return list;
    }

    /**
     * @Description: 485. 最大连续 1 的个数
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/16-13:46
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 0;
            }
        }
        return max > current ? max : current;
    }

    /**
     * @Description: 561. 数组拆分 I
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/16-15:43
     */

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int sum = 0;
        while (i < nums.length) {
            sum += Math.min(nums[i], nums[i + 1]);
            i = i + 2;
        }
        return sum;
    }

    /**
     * @Description: 566. 重塑矩阵
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/16-15:54
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int x = nums.length;
        int y = nums[0].length;
        if (x * y != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                list.add(nums[i][j]);
            }
        }
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = list.get(k);
                k++;
            }
        }
        return result;
    }

    //官方方法
    //知识点：首先将矩阵转换成一维数组。可以知道元素的下标。在矩阵当中，知道一个元素的下标和矩阵大小就可以知道元素的位置（坐标）。
    //元素的坐标等于（index/矩阵的列的个数，index%列的个数）
    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/16-16:46
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return true;
    }

    /**
     * @Description: 628. 三个数的最大乘积
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/16-17:40
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        int ans1 = nums[i] * nums[i - 1] * nums[i - 2];
        int ans2 = nums[0] * nums[1] * nums[i];
        return Math.max(ans1, ans2);
    }

    /**
     * @Description: 643. 子数组最大平均数 I
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/16-18:24
     */

    public double findMaxAverage(int[] nums, int k) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < k; i++) {
            current += nums[i];
        }
        max = current;
        for (int i = 0; i < nums.length - k; i++) {
            current = current + nums[i + k] - nums[i];
            max = Math.max(max, current);
        }
        return (double) max / k;
    }

    /**
     * @Description: 661. 图片平滑器
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/16-18:59
     */
    public int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int[][] result = new int[rows][cols];
        int allCounts = rows * cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                for (int ni = i - 1; ni <= i + 1; ni++) {
                    for (int nj = j - 1; nj <= j + 1; nj++) {
                        if (ni >= 0 && nj >= 0 && ni < rows && nj < cols) {
                            result[i][j] += M[ni][nj];
                            count++;
                        }
                    }
                }
                result[i][j] /= count;
            }
        }
        return result;
    }


    /**
     * @Description: 665. 非递减数列
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/16-19:31
     */


    /**
     * @Description: 674. 最长连续递增序列
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/17-20:04
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int current = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 1;
            }
        }
        return Math.max(max, current);
    }

    /**
     * @Description: 697. 数组的度 (超时)
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/17-20:14
     */
    public int findShortestSubArray(int[] nums) {
        int min = 1;
        int len = 1;
        int right = 0;
        int precount = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            right = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                    right = j;
                }
            }
            if (count > precount) {
                precount = count;
                len = right - i + 1;
                min = len;
            } else if (count == precount) {
                if (min > right - i + 1) {
                    min = right - i + 1;
                }
            }
            count = 1;
            len = 1;
        }
        return min;
    }

    //官方方法
    public int findShortestSubArray1(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0;
        int len = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] array = entry.getValue();
            if (maxNum < array[0]) {
                maxNum = array[0];
                len = array[2] - array[1] + 1;
            } else if (maxNum == array[0]) {
                if (len > array[2] - array[1] + 1) {
                    len = array[2] - array[1] + 1;
                }
            }
        }
        return len;
    }

    /**
     * @Description: 724. 寻找数组的中心下标 前缀和
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/18-16:11
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (total == 2 * sum + nums[i]) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    /**
     * @Description:746. 使用最小花费爬楼梯
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/18-17:38
     */
    public int minCostClimbingStairs(int[] cost) {
        int index = 0;
        int sum = 0;
        while (index < cost.length - 2) {
            if (cost[index] < cost[index + 1]) {
                sum += cost[index];
            } else {
                sum += cost[index + 1];
                index++;
            }
            index++;
        }
        return sum;
    }

    /**
     * @Description: 747. 至少是其他数字两倍的最大数
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/18-19:01
     */
    public int dominantIndex(int[] nums) {

        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }

    /**
     * @Description: 766. 托普利茨矩阵
     * @Param:
     * @return:
     * @Author: huang
     * @Date: 2021/4/20-11:00
     */

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length - 1;
        boolean result = false;
        int cols = matrix[0].length - 1;
        int x = rows;
        int y = 0;
        while (x >= 0 && y <= cols) {
            int m = x;
            int n =y;
            while (m <= rows-1 && n <= cols-1) {
                if (matrix[m][n] == matrix[m + 1][n + 1]) {
                    m++;
                    n++;
                } else {
                    return false;
                }
            }
            if (x != 0) {
                x--;
            }else {
                y++;
            }
        }
        return true;
    }

    //官方方法 优点：不用把每一条斜线确定，只要确定每一个元素的斜边的下一个相等
    public boolean isToeplitzMatrix1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /** 
    * @Description: 830. 较大分组的位置
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/20-13:33
    */

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        char [] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars[left]) {
                right = i ;
            } else {
                if (right - left >= 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    lists.add(list);
                }
                left =i;
            }
            if (right == chars.length - 1) {
                if (right - left >= 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    lists.add(list);
                }
            }
        }

        return lists;
    }
    public List<List<Integer>> largeGroupPositions1(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
    
    /** 
    * @Description: 867. 转置矩阵
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/20-14:14
    */

    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[j][i] = matrix[i][j];
            }
        }


        return res;
    }
    
    /** 
    * @Description: 888. 公平的糖果棒交换
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/20-15:01
    */
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = Arrays.stream(A).sum();
        int bSum = Arrays.stream(B).sum();
        int k = (aSum + bSum) / 2;
        int a = aSum-k;
        int b =bSum-k;
        HashMap<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0;i < A.length;i++) {
            aMap.put(A[i], A[i] - a);
        }
        for (int j = 0; j < B.length; j++) {
            if (aMap.containsValue(B[j])) {
                return new int[]{B[j] - b, B[j]};
            }
        }
        return new int[]{a, b};
    }
    //官方方法
    public int[] fairCandySwap1(int[] A, int[] B) {
        int aSum = Arrays.stream(A).sum();
        int bSum = Arrays.stream(B).sum();
        int k = (aSum - bSum) / 2;
        Set<Integer> aMap = new HashSet<>();
        for (int i = 0;i < A.length;i++) {
            aMap.add(A[i]);
        }
        for (int y : B) {
            int x = y+k;
            if (aMap.contains(x)) {
                return new int[]{x, y};
            }
        }
        return null;
    }
    
    /** 
    * @Description: 896. 单调数列
    * @Param:  
    * @return:  
    * @Author: huang 
    * @Date: 2021/4/20-15:51
    */
    public boolean isMonotonic(int[] A) {

        boolean a = true;
        boolean b = true;
        for (int i = 0; i < A.length-1; i++) {
            if (A[i] <= A[i + 1]) {

            } else {
                a = false;
                break;
            }
        }
        for (int i = 0; i < A.length-1; i++) {
            if (A[i] >= A[i + 1]) {

            } else {
                b = false;
                break;
            }
        }
        return a||b;

    }
    //官方方法 优化了我的方法
    public boolean isMonotonic1(int[] A) {
        boolean a = true;
        boolean b = true;
        for (int i = 0; i < A.length-1; i++) {
            if (A[i] < A[i + 1]) {
                a = false;
            }
            if (A[i]>A[i+1]){
                b = false;
            }
        }
        return a||b;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMonotonic(new int[]{1,1,1}));
    }
}
