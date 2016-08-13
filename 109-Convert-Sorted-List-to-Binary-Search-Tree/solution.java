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
        ListNode[] heads = {head};
        ListNode p = head;
        len = 0;
        while(p != null){
            len ++;
            p = p.next;
        }
        return build(0, len - 1);
    }

    private TreeNode build(int s, int e, ListNode[] heads){
        if(s > e) return null;
        int mid = s - (s - e) / 2;
        TreeNode root = head;
        head = head.next;
        root.left = build(s, mid - 1);
        root.left = build(mid + 1, e);
        return root;
    }
}