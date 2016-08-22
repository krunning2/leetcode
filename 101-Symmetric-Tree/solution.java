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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isValid(root.left, root.right);
    }
    private boolean isValid(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == null && right == null;
        if(left.val != right.val) return false;
        return isValid(left.right, right.left) && isValid(left.left, right.right);
    }
}