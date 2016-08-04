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
        int size;
        int max;
        int upper;
        int lower;
        Result(int s, int m, int u, int l){
            size = s;
            max = m;
            upper = u;
            lower = l;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        Result res = find(root);
        return res.max;
    }
    
    private Result find(TreeNode root){
        if(root == null) return new Result(0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Result left = find(root.left);
        Result right = find(root.right);
        if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower){
            return new Result(-1, Math.max(left.max, right.max), 0, 0);
        }
        int size = left.size + right.size + 1;
        return new Result(size, Math.max(size, Math.max(left.max, right.max)), Math.max(root.val, right.upper), Math.min(root.val, left.lower));
    }

}