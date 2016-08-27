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
            TreeLinkNode leftMost = null;
            TreeLinkNode next = cur;
            while(next != null){
                if(next.left != null){
                    next.left.next = findNext(next, true);
                    if(leftMost == null) leftMost = next.left;
                }
                if(next.right != null){
                    next.right.next = findNext(next, false);
                    if(leftMost == null) leftMost = next.right;
                }
                next = next.next;
            }
            cur = leftMost;
        }
    }
    private TreeLinkNode findNext(TreeLinkNode node, boolean is_left){
        if(is_left && node.right != null){
            return node.right;
        }
        TreeLinkNode next = node.next;
        while(next != null){
            if(next.left != null){
                return next.left;
            }
            if(next.right != null){
                return next.right;
            }
            next = next.next;
        }
        return null;
    }
}