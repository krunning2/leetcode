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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        ListNode p = pre;
        ListNode cur = pre.next;
        for(int i = 0; i <= n - m; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre =cur;
            cur = next;
        }
        p.next.next = cur;
        p.next = pre;
        return dummy.next;
    }
}