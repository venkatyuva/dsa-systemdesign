package com.dsa.math.gcd;

import java.util.*;

public class AllGCDPair {

    public static void main(String[] args) {
        for (int value : new AllGCDPair().solve(new int[]{2, 2, 2, 2, 8, 2, 2, 2, 10})) {
            System.out.println(value);
        }
    }

    public int[] solve(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int value = A[i];
            if (map.containsKey(value)) {
                map.put(value, map.get(value) - 1);
                if (map.get(value) == 0) {
                    map.remove(value);
                }
            } else {
                for (int element : result) {
                    int gcd = gcd(value, element);
                    map.put(gcd, map.getOrDefault(gcd, 0) + 2);
                }
                result.add(value);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
