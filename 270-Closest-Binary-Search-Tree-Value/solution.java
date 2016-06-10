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
        int cur = root.val;
        int kid = cur;
        if(root.val < target && root.right != null){
            kid = closestValue(root.right, target);
        }
        if(root.val > target && root.left != null){
            kid = closestValue(root.left, target);
        }
        return Math.abs(cur - target) < Math.abs(kid - target) ? cur : kid;
    }
   
}