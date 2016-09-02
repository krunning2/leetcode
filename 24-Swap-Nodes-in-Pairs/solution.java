/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, next = head.next;
        while(next != null){
            ListNode tmp = next.next;
            next.next = cur;
            cur.next = tmp;
            pre.next = next;
            pre = cur;
            cur = tmp;
            next = tmp == null ? null : tmp.next;
        }
        return dummy.next;
    }
}