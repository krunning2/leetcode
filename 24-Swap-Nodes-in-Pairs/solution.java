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
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next= head.next;
        while(next != null){
            pre.next = next;
            ListNode tmp = next.next;
            cur.next = tmp;
            next.next = cur;
            pre = cur;
            cur = tmp;
            next = tmp == null ? null tmp.next;
        }
        return dummy.next;
    }
}