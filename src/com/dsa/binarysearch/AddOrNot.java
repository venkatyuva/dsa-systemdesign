package com.dsa.binarysearch;

import java.util.Arrays;

public class AddOrNot {

    public static void main(String[] args) {
        int[] result = new AddOrNot().solve(new int[]{3, 1, 2, 2, 1}, 3);
        System.out.println(result[0] + ", " + result[1]);
    }

    public int[] solve(int[] A, int B) {
        Arrays.sort(A);
        int[] prefix = new int[A.length];
        prefix[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }
        int[] answer = new int[2];
        for (int i = 0; i < A.length; i++) {
            int left = 1;
            int right = i + 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long val1 = A[i];
                long val2 = prefix[i];
                long val3 = i - mid < 0 ? 0 : prefix[i - mid];
                long num = (mid * val1) - (val2 - val3);
                if (num <= B) {
                    if (mid > answer[0]) {
                        answer[0] = mid;
                        answer[1] = A[i];
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return answer;
    }
}
