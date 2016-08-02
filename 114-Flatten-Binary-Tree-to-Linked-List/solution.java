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
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null) flatten(root.right);
        TreeNode left = root.left;
        TreeNode rightMost = left;
        while(rightMost.left != null){
            rightMost = rightMost.right;
        }
        TreeNode right = root.right;
        rightMost.right = right;
        root.right = left;
        
    }
}