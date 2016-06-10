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
        int kid = root.val < target ? closestValue(root.right, target) : closestValue(root.left, target);
        return Math.abs(cur - target) < Math.abs(kid - target) ? cur : kid;
    }
   
}