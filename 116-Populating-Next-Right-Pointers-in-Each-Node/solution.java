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
            TreeLinkNode next = cur;
            while(next != null){
                if(next.left != null)
                    next.left.next = next.right;
                if(next.right != null)
                    next.right.next = next.next == null ? null : next.next.left;
                next = next.next;
            }
            cur = cur.left;
        }
    }
}