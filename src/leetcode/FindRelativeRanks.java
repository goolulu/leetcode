package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 506. 相对名次
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(score.length, (o1, o2) -> o2.score-o1.score);
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            priorityQueue.add(new Pair(i, score[i]));
        }
        for (int i = 0; i < score.length; i++) {
            Pair p = priorityQueue.poll();
            String rank = "";
            if (i == 0) {
                rank = "Gold Medal";
            } else if (i == 1) {
                rank = "Bronze Medal";
            } else if (i == 2) {
                rank = "Silver Medal";
            } else {
                rank = String.valueOf(i + 1);
            }
            ans[p.index] = rank;
        }
        return ans;

    }

    static class Pair{
        public  int index;
        public int score;

        public Pair(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        FindRelativeRanks findRelativeRanks = new FindRelativeRanks();
        System.out.println(findRelativeRanks.findRelativeRanks(new int[]{5, 4, 3, 2, 1}));
        System.out.println(findRelativeRanks.findRelativeRanks(new int[]{10,3,8,9,4}));

    }
}
