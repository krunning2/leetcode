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
        if(preorder == null || inorder == null) return null;
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode build(int[] pre, int[] in, int pS, int pE, int inS, int inE){
        if(pS > pE){
            return null;
        }
        TreeNode root = new TreeNode(pre[pS]);
        int index = find(in, inS, inE, pre[pS]);
        int len = index - inS;
        root.left = build(pre, in, pS, pS + len - 1, inS, index - 1);
        root.right = build(pre, in, pS + len + 1, pE, index + 1, inE);
        return root;
    }
    private int find(int[] in, int inS, int inE, int target){
        for(int i = inS; i <= inE; i++){
            if(in[i] == target) return i;
        }
        return 0;
    }
}