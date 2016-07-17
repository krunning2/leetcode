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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        if(p.right != null){
            return findLeftMost(p.right);
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.val > p.val && cur.left != null && cur.left > p.val){
                cur = cur.left;
            }else if(cur.val > p.val && cur.left != null && cur.left < p.val){
                return cur;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }
    
    private TreeNode findLeftMost(TreeNode node){
        while(node != null && node.left != null){
            node = node.left;
        }
        return node;
    }
}