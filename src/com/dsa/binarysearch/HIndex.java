package com.dsa.binarysearch;

public class HIndex {

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{0, 1, 3, 5, 6}));
    }
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countGreaterThanK(citations, mid) >= mid) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private int countGreaterThanK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= k) {
                answer = array.length - mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
