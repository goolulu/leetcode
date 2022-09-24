package leetcode;

import java.util.Arrays;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        System.out.println(Arrays.toString(getLeastNumbers.getLeastNumbers(new int[]{3, 2, 1}, 2)));
        System.out.println(Arrays.toString(getLeastNumbers.getLeastNumbers(new int[]{0,1,2,1}, 1)));

    }
}
