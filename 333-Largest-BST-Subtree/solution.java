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
    
    class Result{
        int val;
        int max;
        int upper;
        int lower;
        Result(int val, int max, int upper, int lower){
            this.val = val;
            this.max = max;
            this.upper = upper;
            this.lower = lower;
        }
    }
    
    
    public int largestBSTSubtree(TreeNode root) {
        Result res = find(root);
        return res.max;
    }
    
    public Result find(TreeNode root){
        if(root == null) return new Result(0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Result left = find(root.left);
        Result right = find(root.right);
        if(left.val == -1 || right.val == -1 || root.val <= left.upper || root.val >= right.lower){
            return new Result(-1, Math.max(right.max, left.max), 0, 0);
        }
        int size = left.val + right.val + 1;
        return new Result(size, Math.max(size, Math.max(left.max, right.max)), Math.max(root.val, right.upper), Math.min(root.val, left.lower));
    }
}