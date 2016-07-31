/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while(cur != null){
            TreeLinkNode p = cur;
            while(p != null){
                if(p.left != null){
                    p.left.next = p.right;
                }
                if(p.next != null && p.right != null){
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            cur = cur.left;
        }
    }
}