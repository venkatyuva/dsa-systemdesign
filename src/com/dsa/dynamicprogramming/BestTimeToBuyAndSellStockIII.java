package com.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 1, 4}, 7));
    }

    public static int maxProfit(int[] prices, int n)
    {
        Arrays.sort(prices);
        // Write Your Code Here
        int firstBuy = Integer.MAX_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MAX_VALUE;
        int secondSell = 0;
        int max = 0;
        for (int price : prices) {
            firstBuy = Math.min(firstBuy, price);
            firstSell = Math.max(firstSell, price - firstBuy);
            secondBuy = Math.min(secondBuy, price - firstSell);
            secondSell = Math.max(secondSell, price - secondBuy);
            max = Math.max(firstSell, secondSell);
        }
        return max;
    }
}
