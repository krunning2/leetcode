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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int inS, int inE, int postS, int postE){
        if(inS > inE){
            return null;
        }
        int index = find(postorder[postE], inorder);
        int len = index - inS;
        TreeNode root = new TreeNode(postorder[postE]);
        root.left = helper(inorder, postorder, inS, index - 1, postS, postS + len - 1);
        root.right = helper(inorder, postorder, index + 1, inE, postS + len, postE - 1);
        return root;
    }
    private int find(int target, int[] inorder){
        for(int i = 0; i < inorder.length; i++){
            if(target == inorder[i]) return i;
        }
        return 0;
    }
}