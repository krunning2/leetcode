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
    public int kthSmallest(TreeNode root, int k) {
        Node newRoot = build(root);
        return query(newRoot, k);
    }
    
    private int query(Node root, int k){
        if(k <= 0 || k > root.count){
            return -1;
        }
        if(root.left != null){
            if(root.left.count == k - 1){
                return root.val;
            }else if(root.left.count >= k){
                return query(root.left, k);
            }else{
                return query(root.right, k - root.left.count - 1);
            }
        }else{
            if(k == 1){
                return root.val;
            }else{
                return query(root.right, k - 1);
            }
        }
    }
    
    private Node build(TreeNode root){
        if(root == null) return null;
        Node r = new Node(root.val);
        Node left = build(root.left);
        Node right = build(root.right);
        r.left = left;
        r.right = right;
        if(left != null) r.count += left.count;
        if(right != null) r.count += right.count;
        return r;
    }
    class Node{
        int count;
        Node left;
        Node right;
        int val;
        Node(int v){
            val = v;
            count = 1;
        }
    }
}