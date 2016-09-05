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
        while(root != null){
            TreeNode right = root.right;
            if(root.left != null){
                TreeNode rightMost = findRightMost(root.left);
                rightMost.right = right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    private TreeNode findRightMost(TreeNode node){
        while(node != null && node.right != null){
            node = node.right;
        }
        return node;
    }
}