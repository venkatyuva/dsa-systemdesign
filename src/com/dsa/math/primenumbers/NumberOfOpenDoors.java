package com.dsa.math.primenumbers;

import java.util.Arrays;

public class NumberOfOpenDoors {

    public static void main(String[] args) {
        System.out.println(new NumberOfOpenDoors().solve(5041242));
    }

    public int solve(int A) {
        int count = 0;
        for (int i = 1; i * i <= A; i++) {
            count++;
        }
        return count;
    }
}
