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
        if(p == null || root == null){
            return null;
        }
        if(p.right != null) return findLeftMost(p.right);
        TreeNode res = null;
        while(root != null){
            if(root.val > p.val){
                res = root;
                root = root.left;
            }else if(root == p){
                break;
            }else{
                root = root.right;
            }
        }
        return res;
    }
    private TreeNode findLeftMost(TreeNode node){
        TreeNode pre = null, cur = node;
        while(cur != null){
            pre = cur;
            cur = cur.left;
        }
        return pre;
    }
}