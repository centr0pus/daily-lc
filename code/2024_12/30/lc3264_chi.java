class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int imin = 0, min = nums[0];
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    imin = j;
                }
            }
            nums[imin] = min * multiplier;
        }
        return nums;
    }
}
