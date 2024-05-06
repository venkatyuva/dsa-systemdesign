package com.dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubstring {

    private static final Map<Character, Character> parenthesis = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new LongestBalancedSubstring().LBSlength("([[]]()}[]([[]]([[]]))["));
        System.out.println(new LongestBalancedSubstring().LBSlength("[]]"));
    }
    public int LBSlength(final String A) {
        int[] dp = new int[A.length()];
        Arrays.fill(dp, -1);
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            max = Math.max(max, longestBalancedSubstring(i, A, dp));
        }
        return max;
    }

    private int longestBalancedSubstring(int index, String string, int[] dp) {
        if (index <= 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int length = 0;
        if (isCloseChar(string.charAt(index))) {
            if (isOpenChar(string.charAt(index - 1)) && parenthesis.get(string.charAt(index)) == string.charAt(index - 1)) {
                length = 2 + longestBalancedSubstring(index - 2, string, dp);
            } else if (isCloseChar(string.charAt(index - 1))) {
                int subBracketLength = longestBalancedSubstring(index - 1, string, dp);
                if (subBracketLength - 1 >= 0 && isOpenChar(string.charAt(subBracketLength - 1)) &&
                        parenthesis.get(string.charAt(index - 1)) == string.charAt(subBracketLength - 1)) {
                    length = 2 + subBracketLength + longestBalancedSubstring(index - subBracketLength - 2, string, dp);
                }
            }
        }
        dp[index] = length;
        return length;
    }

    static {
        parenthesis.put(')', '(');
        parenthesis.put(']', '[');
        parenthesis.put('}', '{');
    }

    private boolean isOpenChar(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private boolean isCloseChar(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }
}
