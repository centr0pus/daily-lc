class Solution {
    public int thirdMax(int[] nums) {
        int max = nums[0], second = -1, third = -1;
        boolean hasSecond = false, hasThird = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                third = second;
                second = max;
                max = nums[i];
                hasThird = hasSecond;
                hasSecond = true;
            } else if (nums[i] < max && (!hasSecond || nums[i] > second)) {
                third = second;
                second = nums[i];
                hasThird = hasSecond;
                hasSecond = true;
            } else if (hasSecond && nums[i] < second && (!hasThird || nums[i] > third)) {
                third = nums[i];
                hasThird = true;
            }
        }
        return hasThird ? third : max;
    }
}
