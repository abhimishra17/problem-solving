// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:

// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
 

// Constraints:

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100

import java.util.Scanner;

public class SubsetPartitionsum {
    public static void main(String[] args) {
        // Example input array
        int[] nums = {1, 5, 11, 5};

        // Create an instance of Solution
        Solution solution = new Solution();
        
        // Call the canPartition method and print the result
        if (solution.canPartition(nums)) {
            System.out.println("The array can be partitioned into two subsets with equal sum.");
        } else {
            System.out.println("The array cannot be partitioned into two subsets with equal sum.");
        }
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        // Calculate the total sum of the array
        for (int x : nums) {
            sum += x;
        }

        // If the sum is odd, it cannot be divided into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        // Target sum is half of the total sum
        int target = sum / 2;

        // DP table to store whether a subset sum is possible
        boolean[][] dp = new boolean[n][target + 1];

        // Base case: We can always achieve a subset sum of 0
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case: Only the first element can form a subset if it's <= target
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j]; // Do not take the current number
                boolean take = false;

                // Check if we can take the current number
                if (j >= nums[i]) {
                    take = dp[i - 1][j - nums[i]];
                }

                // Current state is true if we can either take or not take the number
                dp[i][j] = take || notTake;
            }
        }

        // The answer is whether we can achieve the target sum using all numbers
        return dp[n - 1][target];
    }
}

