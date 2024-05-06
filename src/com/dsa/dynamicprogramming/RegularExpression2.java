package com.dsa.dynamicprogramming;

public class RegularExpression2 {

    public static void main(String[] args) {
        System.out.println(new RegularExpression2().isMatch("baaaaaabaaaabaaaaababababbaab", "..a*aa*a.aba*a*bab*"));
    }

    public int isMatch(final String A, final String B) {
        return isMatch(A, B, A.length() - 1, B.length() - 1, new Boolean[A.length()][B.length()]) ? 1 : 0;
    }

    private boolean isMatch(String string, String pattern, int index, int patternIndex, Boolean[][] dp) {
        if (index < 0) {
            return patternIndex < 0;
        }
        if (patternIndex < 0) {
            return false;
        }
        if (dp[index][patternIndex] != null) {
            return dp[index][patternIndex];
        }
        boolean isMatch = false;
        if (Character.isAlphabetic(pattern.charAt(patternIndex))) {
            if (string.charAt(index) == pattern.charAt(patternIndex)) {
                isMatch = isMatch(string, pattern, index - 1, patternIndex - 1, dp);
            }
        } else if (pattern.charAt(patternIndex) == '.') {
            isMatch = isMatch(string, pattern, index - 1, patternIndex - 1, dp);
        } else if (pattern.charAt(patternIndex) == '*') {
            isMatch = isMatch(string, pattern, index, patternIndex - 2, dp);
            if (!isMatch) {
                isMatch = isMatch(string, pattern, index - 1, patternIndex, dp);
            }
        }
        dp[index][patternIndex] = isMatch;
        return isMatch;
    }
}
