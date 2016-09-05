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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] preorder, int inS, int inE, int preS, int preE){
        if(inS > inE){
            return null;
        }
        int index = find(preorder[preS], inorder);
        int len = index - inS;
        TreeNode root = new TreeNode(preorder[preS]);
        root.left = helper(inorder, preorder, inS, index - 1, preS + 1, preS + len);
        root.right = helper(inorder, preorder, index + 1, inE, preS + len + 1, preE);
        return root;
    }
    private int find(int target, int[] inorder){
        for(int i = 0; i < inorder.length; i++){
            if(target == inorder[i]) return i;
        }
        return 0;
    }
}