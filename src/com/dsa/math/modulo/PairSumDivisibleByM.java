package com.dsa.math.modulo;

import java.util.HashMap;
import java.util.Map;

public class PairSumDivisibleByM {

    public static void main(String[] args) {
        System.out.println(new PairSumDivisibleByM().solve(new int[]{1, 2, 3, 4, 5}, 2));
    }

    public int solve(int[] A, int B) {
        int mod = 1000000007;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : A) {
            int x = number % B;
            int balance;
            if (x == 0) {
                balance = 0;
            } else {
                balance = B - x;
            }
            sum += (map.getOrDefault(balance, 0)) % mod;
            sum %= mod;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return sum;
    }
}
