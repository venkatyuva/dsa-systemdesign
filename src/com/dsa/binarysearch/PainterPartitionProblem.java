package com.dsa.binarysearch;

public class PainterPartitionProblem {

    public static void main(String[] args) {
        System.out.println(new PainterPartitionProblem().paint(1, 1000000, new int[]{1000000, 1000000}));
    }
    private int mod = 10000003;
    public int paint(int A, int B, int[] C) {
        int max = 0;
        int sum = 0;
        for (int value : C) {
            max = Math.max(max, value);
            sum += value;
        }
        if (A == 1) {
            return (int) (((long) sum * B) % mod);
        }
        int answer = sum;
        long left = max;
        long right = sum;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isPaintersPartitioned(C, mid, A)) {
                answer = (int) mid % mod;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) (((long) answer * B) % mod);
    }

    private boolean isPaintersPartitioned(int[] boards, long limit, int workersCount) {
        int count = 1;
        int total = 0;
        for (int board : boards) {
            if ((long) (board + total) <= limit) {
                total += board;
            } else {
                count++;
                total = board;
                if (count > workersCount) {
                    return false;
                }
            }
        }
        return true;
    }
}
