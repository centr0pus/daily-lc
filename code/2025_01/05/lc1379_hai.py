class Solution(object):
    def getTargetCopy(self, original, cloned, target):
        s = [cloned]
        while(s):
            cur = s.pop(0)
			if cur.val == target.val:
                return cur
			else:
                if cur.left != None:
                    stack.append(cur.left)
                if cur.right != None:
                    stack.append(cur.right)
