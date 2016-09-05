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
        Result res = new Result();
        getMaxPathSum(root, res);
        return res.val;
    }
    private int getMaxPathSum(TreeNode root, Result res){
        if(root == null){
            return 0;
        }
        int left = getMaxPathSum(root.left, res);
        int right = getMaxPathSum(root.right, res);
        int singlePath = Math.max(root.val, Math.max(left, right) + root.val);
        res.val = Math.max(res.val, Math.max(singlePath, root.val + left + right));
        return singlePath;
    }
    class Result{
        int val;
        Result(){
            val = Integer.MIN_VALUE;
        }
    }
    
}