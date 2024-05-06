package com.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class InfiniteArraySum {

    public static void main(String[] args) {
        List<List<Long>> queries = new ArrayList<>();
        List<Long> query = new ArrayList<>();
        query.add(Long.valueOf(1));
        query.add(Long.valueOf(5));
        queries.add(query);
        query = new ArrayList<>();
        query.add(Long.valueOf(4));
        query.add(Long.valueOf(8));
        queries.add(query);
        System.out.println(sumInRanges(new int[]{12, 14, 53}, 3, queries, queries.size()));
    }

    private static int mod = 1000000007;
    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

        // Write your code here!
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            dp[i] = sum;
        }
        List<Integer> list = new ArrayList<>();
        for (List<Long> query : queries) {
            int start = (int) query.get(0).intValue() - 1;
            int end = (int) query.get(1).intValue();
            list.add(getSum(dp, end, false) - getSum(dp, start, true));
        }
        return list;
    }

    private static int getSum(int[] dp, int index, boolean isStart) {
        if (index < 0) {
            return 0;
        }
        if (index < dp.length) {
            return dp[index];
        }
        int quotient = index / dp.length;
        int remainder = isStart ? index % dp.length : index - 1 % dp.length;
        int sum =(quotient * dp[dp.length - 1]) %mod;
        sum += dp[remainder];
        sum %= mod;
        return sum;
    }
}
