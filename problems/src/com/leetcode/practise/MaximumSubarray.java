package com.leetcode.practise;

// https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubarray {

    public int maxSubArrayn3(int[] nums) {
        // find all subarray sum and find max out of it
        // n^2 to find all the subarray and n to calculate to sum of each subarray
        // total time complexity would be n^3
        return 0;
    }

    public int maxSubArrayPrefixSum(int[] nums) {
        // calculate prefix sum of given array
        // set start and end index of subarray and calculate its sum using prefix sum
        // total time complexity n^2 : n^2 to find start and end index of subarray and n to calculate it prefix sum
        return 0;
    }

    public int maxSubArraykadens(int[] nums) {
        // Define a global variable and local variable
        // iterate from 0 to n-1 and keep adding current val and reset it once it is negative
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for (int val : nums) {
            currentSum += val;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) currentSum = 0;
        }
        return maxSum;
    }

}
