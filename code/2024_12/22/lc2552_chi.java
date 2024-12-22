class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][] pre = new int[n][n]; //pre[k][j]: count number index i < j and nums[i] < nums[k]
        int[][] suf = new int[n][n]; //suf[j][k]: count number index l > k and nums[l] > nums[j]
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < i; j++) {
                pre[i][j] = pre[i][j - 1] + (nums[j - 1] < nums[i] ? 1 : 0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = n - 2; j > i; j--) {
                suf[i][j] = suf[i][j + 1] + (nums[j + 1] > nums[i] ? 1 : 0);
            }
        }
        long ans = 0L;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    ans += pre[j][i] * suf[i][j];
                }
            }
        }
        return ans;
    }
}
