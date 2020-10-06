// 152. Maximum Product Subarray
// Medium

// 5230

// 177

// Add to List

// Share
// Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

// Example 1:

// Input: [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:

// Input: [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// Accepted
// 396,000
// Submissions
// 1,227,150


// idea:


class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        // save the maximum value so far
        int max_so_far = nums[0];
        // save the possibility to see another negative value
        int min_so_far = nums[0];
        // save the global maximum value
        int result = max_so_far;

        //calculate the max and min between three values (curr, max_so_far * curr, min_so_far * curr)
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));
            max_so_far = temp_max;
            result = Math.max(max_so_far, result);
        }

        return result;
    }
}