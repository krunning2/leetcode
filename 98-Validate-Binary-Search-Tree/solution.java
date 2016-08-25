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
    public boolean isValidBST(TreeNode root) {
        long[] min = {Long.MIN_VALUE};
        return validate(root, min);
    }
    private boolean validate(TreeNode root, long[] min){
        if(root == null) return true;
        if(!validate(root.left, min)) return false;
        if(min[0] >= root.val) return false;
        min[0] = root.val;
        if(!validate(root.right, min)) return false;
        return true;
    }
}