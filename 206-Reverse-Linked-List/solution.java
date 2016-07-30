/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while(p != null){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
    private ListNode reverse(ListNode head, ListNode newHead){
        if(head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }
}