class Solution(object):
    def longestAlternatingSubarray(self, nums, threshold):
        l = 0
        r = 0
        res = 0 

        while r < len(nums):
            if nums[r] % 2 == 0 and nums[r] <= threshold:
                while r + 1 < len(nums) and nums[r] % 2 != nums[r + 1] % 2 and nums[r + 1] <= threshold:
                    r += 1
                res = max(res, r - l + 1)
            r += 1
            l = r
        
        return res
        
