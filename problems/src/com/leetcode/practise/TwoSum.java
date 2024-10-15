package com.leetcode.practise;

import java.util.HashMap;

// https://leetcode.com/problems/two-sum/description/
public class TwoSum {

    // n^2
    public int[] twoSumNaive(int[] nums, int target) {
        // pick any index and keep finding until we find the remaining part
        for (int i = 0; i < nums.length - 1; i++) {
            int required = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == required)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    // O(n) with O(n) space
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (valIndexMap.containsKey(remaining)) {
                return new int[]{i, valIndexMap.get(remaining)};
            }
            valIndexMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {

    }
}
