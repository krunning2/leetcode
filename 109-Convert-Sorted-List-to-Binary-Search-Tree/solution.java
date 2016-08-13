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
        if(head == null) return null;
        ListNode[] heads = {head};
        ListNode p = head;
        int len = getLen(head);
        return build(0, len - 1, heads);
    }
    
    private int getLen(ListNode head){
        int count = 0;
        while(head != null){
            count ++;
            head = head.next;
        }
        return count;
    }

    private TreeNode build(int s, int e, ListNode[] heads){
        if(s > e) return null;
        int mid = s - (s - e) / 2;
        TreeNode left = build(s, mid - 1, heads);
        TreeNode root = new TreeNode(heads[0].val);
        heads[0] = heads[0].next;
        TreeNode right = build(mid + 1, e, heads);
        root.left = left;
        root.right = right;
        return root;
    }
}