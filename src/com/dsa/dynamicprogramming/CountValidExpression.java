package com.dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountValidExpression {

    public static void main(String[] args) {
        System.out.println(new CountValidExpression().countValidExpressions(new int[]{1, 2, 1}, 2));
    }

    public int countValidExpressions(int[] nums, int target) {
        int sum = 0;
        for (int value : nums) {
            sum += value;
        }
        if ((sum + target) % 2 != 0 || target > sum || target < -sum) {
            return 0;
        }
        return countValidExpressions(nums.length - 1, target, nums, new HashMap<>());
    }

    private int countValidExpressions(int index, int target, int[] nums, Map<String, Integer> dp) {
        if (index < 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp.containsKey(index + "|" + target)) {
            return dp.get(index + "|" + target);
        }
        int count = countValidExpressions(index - 1, target - nums[index], nums, dp) + countValidExpressions(index - 1, target + nums[index], nums, dp);
        dp.put(index + "|" + target, count);
        return count;
    }
}
