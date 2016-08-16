/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 1; i < m; i++){
            p = p.next;
        }
        ListNode pre = p;
        ListNode cur = p.next;
        ListNode next = cur == null ? null : cur.next;
        for(int i = 0; i < n - m; i++){
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        if(p != null && p.next != null){
            p.next.next = next;
            p.next = cur;
        }
        return dummy.next;
    }
}