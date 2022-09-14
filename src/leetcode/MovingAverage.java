package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 */
public class MovingAverage {
    Queue<Integer> queue ;
    int size;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() < size) {
            sum += val;
            queue.offer(val);
            return (double) sum / queue.size();
        } else {
            sum -= queue.poll();
            queue.offer(val);
            sum += val;
            return (double) sum / size;
        }
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}

