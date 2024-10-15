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
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int opp = target - nums[i];
            if (map.containsKey(opp)) {
                return new int[]{i, map.get(opp)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
