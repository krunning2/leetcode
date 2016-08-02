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
        while(root != null){
            if(root.left != null){
                TreeNode pre = root.left;
                while(pre != null && pre.right != null){
                    pre = pre.right;
                }
                TreeNode tmp = root.right;
                root.right = root.left;
                root.left = null;
                pre.right = tmp;
            }
            root = root.right;
        }
    }
}