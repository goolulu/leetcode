package leetcode.algorithm.backtracking;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author huangrenning
 * @date 2023/7/16 15:24:43
 */
public class Solution {

    /**
     * 77. 组合
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, k, 0, list, res);
        return res;
    }

    private void dfs(int[] nums, int k, int currIndex, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = currIndex; i < nums.length - (k - list.size()) + 1; i++) {
            list.add(nums[i]);
            dfs(nums, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }

    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfscombinationSum3(k, n, 0, list, result, 1);
        return result;
    }

    private void dfscombinationSum3(int k, int targetSum, int sum, List<Integer> list, List<List<Integer>> result, int currIndex) {
        if (sum > targetSum) {
            return;
        }
        if (list.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = currIndex; i <= 9 - (k - list.size()) + 1; i++) {
            sum += i;
            list.add(i);
            dfscombinationSum3(k, targetSum, sum, list, result, i + 1);
            list.remove(list.size() - 1);
            sum -= i;
        }
    }

    /**
     * 39. 组合总和
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfsCombinationSum(candidates, target, 0,0, list, res);
        return res;
    }

    private void dfsCombinationSum(int[] candidates, int target,int currIndex, int sum, List<Integer> list, List<List<Integer>> res) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = currIndex; i < candidates.length ; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            sum += candidates[i];
            dfsCombinationSum(candidates, target, i, sum, list, res);
            list.remove(list.size() - 1);

        }
    }

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     *
     * 注意：解集不能包含重复的组合。
     * 40. 组合总和 II
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        dfsCombinationSum2(candidates, target, 0, 0, list, res);
        return new ArrayList<>(res);
    }

    private void dfsCombinationSum2(int[] candidates, int target, int currIndex, int sum, List<Integer> list, Set<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = currIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            dfsCombinationSum2(candidates, target, i + 1, sum, list, res);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum2(IntStream.of(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1).toArray(), 30));
        System.out.println(s.combinationSum2(IntStream.of(2,5,2,1,2).toArray(), 5));
    }
}
