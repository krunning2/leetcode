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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && sum == root.val) return true;
        boolean check = false;
        if(root.left != null) 
            check |= hasPathSum(root.left, sum - root.val);
        if(root.right != null) 
            check |= hasPathSum(root.right, sum - root.val);
        return check;
    }
}