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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode l = null;
        TreeNode r = null;
        TreeNode p = null;
        TreeNode node = root;
        while(node != null){
        //node.left should point to the last right leaf
            l = node.left;
            node.left = r;
            r = node.right;
            node.right = p;
            p = node;
            node = l;
        }
        return p;
    }
}