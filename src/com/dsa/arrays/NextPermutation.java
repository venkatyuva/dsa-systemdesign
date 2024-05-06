package com.dsa.arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nextPermutation = new NextPermutation().nextPermutation(new int[]{2, 3, 1, 3, 3});
        for (int value : nextPermutation) {
            System.out.print(value + " ");
        }
    }
    public int[] nextPermutation(int[] A) {
        int pivot = -1;
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] > A[i - 1]) {
                pivot = i - 1;
                break;
            }
        }
        if (pivot == -1) {
            sort(A, 0, A.length - 1);
            return A;
        }
        int index = smallestElementGreaterThanElement(A, A[pivot], pivot + 1);
        swap(A, pivot, index);
        sort(A, pivot + 1, A.length - 1);
        return A;
    }

    private int smallestElementGreaterThanElement(int[] array, int element, int start) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < array.length; i++) {
            if (array[i] > element && array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(array, start, mid);
        sort(array, mid + 1, end);
        mergeTwoSortedArrays(array, start, mid, end);
    }

    private void mergeTwoSortedArrays(int[] array, int left, int mid, int right) {
        int[] sorted = new int[right - left + 1];
        int first = left;
        int second = mid + 1;
        int index = 0;
        while (first <= mid && second <= right) {
            if (array[first] < array[second]) {
                sorted[index++] = array[first++];
            } else {
                sorted[index++] = array[second++];
            }
        }
        while (first <= mid) {
            sorted[index++] = array[first++];
        }
        while (second <= right) {
            sorted[index++] = array[second++];
        }
        for (int i = left; i <= right; i++) {
            array[i] = sorted[i - left];
        }
    }
}
