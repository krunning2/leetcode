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
    private void insert(Node root, int x){
        Node pre = root;
        while(root != null){
            pre = root;
            root.count++;
            if(root.val > x){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        if(pre.val > x){
            pre.left = new Node(x);
        }else{
            pre.right = new Node(x);
        }
    }
    
    private void delete(Node root, int x){
        Node pre = root;
        while(root != null){
            pre = root;
            if(root.val > x){
                root = root.left;
                root.count--;
            }else if(root.val < x){
                root = root.right;
                root.count--;
            } else {
                Node replaced = null;
                if(root.left != null){
                    replaced = root.left;
                    Node tmp = null;
                    while(replaced.right != null){
                        replaced.count--;
                        tmp = replaced;
                        replaced = replaced.right;
                    }
                    // remove the right child
                    if(tmp != null){
                        tmp.right = null;
                    }
                }else if(root.right != null){
                    replaced = root.right;
                    Node tmp = null;
                    while(replaced.left != null){
                        replaced.count--;
                        tmp = replaced;
                        replaced = replaced.left;
                    }
                    // remove the left child
                    if(tmp != null){
                        tmp.left = null;
                    }
                }else{
                    if(pre.val < x){
                        pre.right = replaced;
                    }else{
                        pre.left = replace;
                    }
                }
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