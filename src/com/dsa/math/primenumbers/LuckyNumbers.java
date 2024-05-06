package com.dsa.math.primenumbers;

import java.util.Arrays;

public class LuckyNumbers {

    public static void main(String[] args) {
        System.out.println(new LuckyNumbers().solve(8));
    }

    public int solve(int A) {
        int[] cpd = countPrimeDivisors(A);
        int count = 0;
        for (int i = 2; i <= A; i++) {
            if (cpd[i] == 2) {
                count++;
            }
        }
        return count;
    }

    private int[] countPrimeDivisors(int n) {
        int[] cpd = new int[n + 1];
        Arrays.fill(cpd, 0);
        for (int i = 2; i <= n; i++) {
            if (cpd[i] == 0) {
                for (int j = 2 * i; j <= n; j += i) {
                    cpd[j]++;
                }
            }
        }
        return cpd;
    }
}
