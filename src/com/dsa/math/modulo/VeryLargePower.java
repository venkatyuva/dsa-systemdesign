package com.dsa.math.modulo;

public class VeryLargePower {

    public static void main(String[] args) {
        System.out.println(new VeryLargePower().solve(2, 27));
//        long value = 17179869184L;
//        System.out.println(value % 1000000007);
    }

    public int solve(int A, int B) {
        long mod = 1000000007;
        return (int) power(A, factorial(B, mod), mod);
    }

    private long factorial(long n, long mod) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = (factorial * i) % (mod - 1);
        }
        return factorial;
    }

    private long power(long a, long x, long mod) {
        if (x == 0) {
            return 1;
        }
        long half = power(a, x / 2, mod);
        long square = half * half;
        if (x % 2 == 0) {
            return square % mod;
        }
        return ((square % mod) * a) % mod;
    }
}
