
class DP9 {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // DP relation
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Track max
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
