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
        int res = root.val;
        while(root != null){
            res = Math.abs(root.val - target) < Math.abs(res - target) ? root.val : res;
            if(root.val < target) root = root.right;
            else root = root.left;
        }
        return res;
    }
   
}