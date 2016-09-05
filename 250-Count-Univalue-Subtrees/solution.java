/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        isUnival(root);
        return count;
    }
    
    private boolean isUnival(TreeNode root) {
        if (root == null) return true;
        if (isUnival(root.left) & isUnival(root.right)) {
            if (root.right != null && root.right.val != root.val || root.left != null && root.left.val != root.val) return false;
            count++;
            return true;
        }
        return false;
    }
}