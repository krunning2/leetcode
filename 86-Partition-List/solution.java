/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        if(head == null || head.next == null) return head;
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = dummy;
        while(p != null && p.val < x){
            pre = p;
            p = p.next;
        }
        ListNode p2 = p;
        while(p != null){
            if(p.val < x){
                p2.next = p.next;
                p.next = pre.next;
                pre.next = p;
                pre = p;
                p = p2.next;
            }else{
                p2 = p;
                p = p.next;
            }
        }
        return dummy.next;
    }
}