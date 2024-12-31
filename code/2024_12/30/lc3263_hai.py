class Solution(object):
    def getFinalState(self, nums, k, multiplier):
        while k>0:
            a = [(num, i) for i, num in enumerate(nums)]
            heapq.heapify(a)
            num, i = heapq.heappop(a)
            nums[i] = num*multiplier
            k -= 1
        return nums
        
