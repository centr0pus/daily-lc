
// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
}

//Solution
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return findCloned(cloned, target.val);
    }

    private TreeNode findCloned(TreeNode cloned, int val) {
        if (cloned == null) return null;
        if (cloned.val == val) return cloned;
        TreeNode result = findCloned(cloned.left, val);
        return result != null ? result : findCloned(cloned.right, val);
    }
}
