package com.dsa.binarysearch;

import java.util.Arrays;

public class MinimumDifference {

    public static void main(String[] args) {
        System.out.println(new MinimumDifference().solve(3, 2, new int[][]{{7, 3}, {2, 1}, {4, 9}}));
    }

    public int solve(int A, int B, int[][] C) {
        for (int i = 0; i < C.length; i++) {
            Arrays.sort(C[i]);
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < A - 1; i++) {
            for (int j = 0; j < B; j++) {
                answer = Math.min(answer, Math.min(upperBound(C[i + 1], C[i][j]) - C[i][j], C[i][j] - lowerBound(C[i + 1], C[i][j])));
            }
        }
        return answer;
    }

    private int upperBound(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        int answer = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= value) {
                answer = array[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private int lowerBound(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= value) {
                answer = array[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
