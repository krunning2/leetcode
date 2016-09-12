/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head;
        ListNode newHead = head.next;
        while(p != null && p.next != null){
            ListNode next = p.next;
            p.next = p.next.next;
            p = next;
        }
        p = head;
        while(p != null && p.next != null){
            p = p.next;
        }
        p.next = newHead;
        return head;
    }
}