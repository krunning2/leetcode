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
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int end = 0;
        ListNode p = head;
        while(p!=null){
            end++;
            p = p.next;
        }
        return build(0, end - 1);
    }
    
    private TreeNode build(int start, int end){
        if(start > end){
            return null;
        }
        int mid = start - (start - end) / 2;
        TreeNode left = build(start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = left;
        root.right = build(mid + 1, end);
        return root;
    }
    
    
}