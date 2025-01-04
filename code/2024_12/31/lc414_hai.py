class Solution(object):
    def thirdMax(self, nums):
        sn = list(set(nums))
        sn.sort(reverse=True)
        if len(sn)>=3:
            return sn[2]
        else:
            return max(sn)
        
