class Solution {
public:
    long long countQuadruplets(vector<int>& nums) {
        long long res = 0;
        int n = nums.size();
        vector<vector<int>> prefix(n, vector<int>(n + 1, 0));
        vector<vector<int>> right(n, vector<int>(n + 1, 0));
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            for (int j = nums[i-1] + 1; j <= n; j++)
                prefix[i][j]++;
        }
        for (int i = n-2; i >= 0; i--) {
            right[i] = right[i+1];
            for (int j = 0; j < nums[i+1]; j++)
                right[i][j]++;
        }
        for (int i = 0; i < n; i++) 
            for (int j = i+1; j < n; j++) 
                if (nums[j] <= nums[i])
                    res += prefix[i][nums[j]] * right[j][nums[i]];
    
        return res;
    }
};
