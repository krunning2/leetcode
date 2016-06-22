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
    public int maxPathSum(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        int[] max = {Integer.MIN_VALUE};
        find(root, max);
        return max[0];
    }
    private int find(TreeNode node, int[] max){
        if(node == null) return 0;
        int left = find(node.left, max);
        int right = find(node.right, max);
        int branchMax = Math.max(Math.max(left, right) + node.val, node.val);
        int crossMax = Math.max(branchMax, left + right + node.val);
        max[0] = Math.max(max[0], crossMax);
        return branchMax;
    }
}