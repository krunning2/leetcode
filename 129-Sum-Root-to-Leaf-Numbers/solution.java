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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int[] sum = {0};
        DFS(root, 0, sum);
        return sum[0];
    }
    private void DFS(TreeNode root, int pre, int[] sum){
        if(root == null){
            return;
        }
        int cur = pre * 10 + root.val;
        if(root.left == null && root.right == null){
            sum[0] += cur;
        }
        DFS(root.left, cur, sum);
        DFS(root.right, cur, sum);
    }
}