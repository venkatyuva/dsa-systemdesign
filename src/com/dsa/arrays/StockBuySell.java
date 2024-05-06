package com.dsa.arrays;

import java.util.ArrayList;

public class StockBuySell {

    public static void main(String[] args) {
        System.out.println(new StockBuySell().stockBuySell(new int[]{100, 180, 260, 310, 40, 535, 695}, 7));
    }

    private ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int buy = 0;
        int sell = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                sell = i;
            } else if (A[i] < A[i - 1] && buy < sell) {
                ArrayList<Integer> profit = new ArrayList<>();
                profit.add(buy);
                profit.add(sell);
                result.add(profit);
                buy = i;
            }
        }
        if (buy < sell) {
            ArrayList<Integer> profit = new ArrayList<>();
            profit.add(buy);
            profit.add(sell);
            result.add(profit);
        }
        return result;
    }
}
