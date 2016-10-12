/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 0; i < n; i++){
            p = p.next;
        }
        ListNode p2 = dummy;
        while(p != null && p.next != null){
            p = p.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}