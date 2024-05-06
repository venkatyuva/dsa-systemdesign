package com.dsa.arrays;

public class SubMatrixSumQuery {
    private int mod = 1000000007;

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new SubMatrixSumQuery().calculatePrefixSumForMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private void calculatePrefixSumForMatrix(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            long value = ((long) A[i - 1][0]) + A[i][0];
            A[i][0] = (int) value % mod;
        }
        for (int i = 1; i < A[0].length; i++) {
            long value = ((long) A[0][i - 1]) + A[0][i];
            A[0][i] = (int) value % mod;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A[i].length; j++) {
                long prevRow = (long) A[i - 1][j];
                long prevCol = (long) A[i][j - 1];
                long prevRowCol = (long) A[i - 1][j - 1];
                long value = (((((prevRow + prevCol) % mod) - prevRowCol) % mod) + A[i][j]) % mod;
                A[i][j] = ((int) value) % mod;
            }
        }
    }
}
