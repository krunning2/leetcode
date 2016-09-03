/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //cur[0] means don't rob current, cur[1] means rob current
public class Solution {
    public int rob(TreeNode root) {
        int[] cur = helper(root);
        return Math.max(cur[0], cur[1]);
    }
    private int[] helper(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int left[] = helper(root.left);
        int right[] = helper(root.right);
        int[] cur = new int[2];
        cur[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        cur[1] = root.val + left[0] + right[0];
        return cur;
    }
}