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
        find(node, root.val, max);
        return max[0];
    }
    private int find(TreeNode node, int cur, int[] max){
        if(node == null) return 0;
        int left = find(node.left, cur + node.val, max);
        int right = find(node.right, cur + node.val, max);
        int branchMax = Math.max(left, right);
        int curMax = Math.max(branchMax, cur);
        max[0] = Math.max(max[0], curMax);
        return curMax;
    }
}