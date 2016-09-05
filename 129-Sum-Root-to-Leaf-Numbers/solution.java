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
        int[] sum = new int[1];
        getSum(root, 0, sum);
        return sum[0];
    }
    private void getSum(TreeNode root, int pre, int[] sum){
        if(root == null) return;
        int cur = pre * 10 + root.val;
        if(root.left == null && root.right == null){
            sum[0] += cur;
        }
        getSum(root.left, cur, sum);
        getSum(root.right, cur, sum);
    }
}