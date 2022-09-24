package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            } else {
                int min = priorityQueue.poll();
                priorityQueue.offer(Math.max(min, nums[i]));
            }

        }
    }

    public int add(int val) {
        if (priorityQueue.isEmpty()) {
            priorityQueue.add(val);
            return val;
        } else if (priorityQueue.size() < k) {
            priorityQueue.add(val);
            return priorityQueue.peek();
        } else {
            int max = Math.max(priorityQueue.poll(), val);
            priorityQueue.add(max);
            return priorityQueue.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2,new int[]{0});
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(3));

    }
}


//["KthLargest","add","add","add","add","add"]
//        [[1,[]],[-3],[-2],[-4],[0],[4]]
//[[2,[0]],[-1],[1],[-2],[-4],[3]]

/*
k = 3 [4, 5, 8], [3]
4
[5, 5, 8], [5]
5
[5, 8, 5], [10]
5
[4, 5, 8, 2, 3, 5, 10], [9]
8
[4, 5, 8, 2, 3, 5, 10, 9] [4]
8



*/
