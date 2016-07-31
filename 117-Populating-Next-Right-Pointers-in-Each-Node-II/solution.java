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
        TreeLinkNode left = null;
        while(cur != null){
            TreeLinkNode p = cur;
            while(p != null){
                if(p.left != null){
                    p.left.next = getNext(p, true);
                    if(left == null){
                        left = p.left;
                    }
                }
                if(p.right != null){
                    p.right.next = getNext(p, false);
                    if(left == null){
                        left = p.right;
                    }
                }
                p = p.next;
            }
            cur = left;
        }
    }
    private TreeLinkNode getNext(TreeLinkNode parent, boolean isLeft){
        if(parent.right != null && isLeft){
            return parent.right;
        }
        TreeLinkNode next = parent.next;
        while(next != null){
            if(next.left != null){
                return next.left;
            }else if(next.right != null){
                return next.right;
            }else{
                next = next.next;
            }
        }
        return null;
    }
}