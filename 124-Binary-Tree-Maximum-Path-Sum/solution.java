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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        singleMaxSum(root);
        return max;
    }
    private int singleMaxSum(TreeNode root){
        if(root == null) return 0;
        int left = singleMaxSum(root.left);
        int right = singleMaxSum(root.right);
        int singleMax = Math.max(root.val, root.val + Math.max(left, right));
        max = Math.max(max, Math.max(singleMax, root.val + left + right));
        return singleMax;
    }
}