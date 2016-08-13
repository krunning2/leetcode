/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {  
        if(head == null) return null;
        int len = getLen(head);
        return build(0, len - 1, new Pointer(head));
    }
    private int getLen(ListNode head){
        int count = 0;
        while(head != null){
            count ++;
            head = head.next;
        }
        return count;
    }
    private TreeNode build(int start, int end, Pointer p){
        if(start > end){
            return null;
        }
        int mid = start - (start - end) / 2;
        TreeNode left = build(start, mid - 1, p);
        TreeNode root = new TreeNode(p.cur.val);
        p.cur = p.cur.next;
        TreeNode right = build(mid + 1, end, p);
        root.left = left;
        root.right = right;
        return root;
    }
    class Pointer {
        ListNode cur;
        Pointer(ListNode cur){
            this.cur = cur;
        }
    }
}