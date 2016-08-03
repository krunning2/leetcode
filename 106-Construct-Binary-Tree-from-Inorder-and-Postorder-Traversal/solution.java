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
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int inS, int inE, int pS, int pE){
        if(inS > inE){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pE]);
        int index = find(inS, inE, inorder, postorder[pE]);
        int len = index - inS;
        root.left = build(inorder, postorder, inS, index - 1, pS, pS + len - 1);
        root.right = build(inorder, postorder, index + 1, inE, pS + len, pE - 1);
        return root;
    }
    private int find(int inS, int inE, int[] inorder, int target){
        for(int i = inS; i <= inE; i++){
            if(inorder[i] == target) return i;
        }
        return 0;
    }
}