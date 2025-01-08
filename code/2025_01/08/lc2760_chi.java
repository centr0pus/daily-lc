class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int l = 0, r = 0, ans = 0;
        while (l < nums.length) {
            while (l < nums.length && (nums[l] % 2 == 1 || nums[l] > threshold)) l++;
            if (l == nums.length) break;
            r = l + 1;
            while (r < nums.length && nums[r] <= threshold && (nums[r] + r - l) % 2 == 0) r++;
            ans = Math.max(ans, r - l);
            l = r;
        }
        return ans;
    }
}