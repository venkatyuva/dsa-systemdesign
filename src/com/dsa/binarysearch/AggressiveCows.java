package com.dsa.binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        System.out.println(new AggressiveCows().solve(new int[]{5, 17, 100, 11}, 2));
    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int left = A[A.length - 1] - A[0];
        int right = A[A.length - 1] - A[0];
        for (int i = 1; i < A.length; i++) {
            left = Math.min(left, A[i] - A[i - 1]);
        }
        int answer = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canTheCowsTied(A, mid, B)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private boolean canTheCowsTied(int[] stalls, int distance, int cowsCount) {
        int current = stalls[0];
        int count = 1;
        for (int i  = 1; i < stalls.length; i++) {
            int stall = stalls[i];
            if (stall - current >= distance) {
                current = stall;
                count++;
            }
        }
        return count >= cowsCount;
    }
}
