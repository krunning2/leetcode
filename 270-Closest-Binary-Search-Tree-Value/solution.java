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
    public int closestValue(TreeNode root, double target) {
        if(root == null){
            throw new RuntimeException("Root can't be null");
        }
        int[] res = {root.val};
        helper(root, target, res);
        return res[0];
    }
    private void helper(TreeNode root, double target, int[] res){
        if(root == null){
            return;
        }
        if(Math.abs(root.val - target) < Math.abs(res[0] - target)){
            res[0] = root.val;
        }
        if(target > root.val){
            helper(root.right, target, res);
        }else{
            helper(root.left, target, res);
        }
    }
}