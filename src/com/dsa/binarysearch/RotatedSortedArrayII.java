package com.dsa.binarysearch;

public class RotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println(new RotatedSortedArrayII().search(new int[]{1, 0, 1, 1, 1}, 0));
    }

    public boolean search(int[] nums, int target) {
        int pivot = pivot(nums);
        if (target > nums[nums.length - 1]) {
            return binarySearch(nums, 0, pivot, target);
        }
        return binarySearch(nums, pivot + 1, nums.length - 1, target) || binarySearch(nums, 0, pivot, target);
    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    private int pivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pivot = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[nums.length - 1]) {
                pivot = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pivot;
    }
}
