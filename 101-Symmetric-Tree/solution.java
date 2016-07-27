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
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == null && right == null;
        if(left.val != right.val) return false;
        if(left.left == null && right.right != null || right.right == null && left.left != null) return false;
        if(left.left != null && right.right != null && (left.left.val != right.right.val) return false;
        if(left.right != null && right.left != null && (left.right.val != right.left.val) return false;
        return true;
    }
}