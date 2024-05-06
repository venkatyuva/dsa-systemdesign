package com.dsa.dynamicprogramming;

import java.util.Arrays;

public class PalindromePartitioning {

    private Boolean[][] isPalindrome;
    private int[] dp;

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().minCut("ababb"));
    }
    public int minCut(String A) {
        if (A.length() == 1) {
            return 0;
        }
        isPalindrome = new Boolean[A.length() + 1][A.length() + 1];
        dp = new int[A.length() + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < A.length(); i++) {
            for (int j = i; j < A.length(); j++) {
                isPalindrome(A, i, j);
            }
        }
        return minCutRequired(A, A.length() - 1);
    }

    private int minCutRequired(String string, int index) {
        if (index < 0 || isPalindrome[0][index]) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int cut = string.length() - 1;
        for (int i = index; i >= 0; i--) {
            if (isPalindrome[i][index]) {
                cut = Math.min(cut, minCutRequired(string, i - 1) + 1);
            }
        }
        dp[index] = cut;
        return dp[index];
    }

    private boolean isPalindrome(String string, int start, int end) {
        if (start > end) {
            return true;
        }
        if (isPalindrome[start][end] != null) {
            return isPalindrome[start][end];
        }
        boolean palindrome = string.charAt(start) == string.charAt(end) &&
                isPalindrome(string, start + 1, end - 1);
        isPalindrome[start][end] = palindrome;
        return palindrome;
    }
}
