class Solution(object):
    def minLength(self, s):
        while True:
            prev = len(s)
            s = s.replace("AB", "").replace("CD", "")
            if len(s) == prev:
                break
        return len(s)
