/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;
        ListNode p = dummy;
        while(p != null){
            if(p.next != null && p.val == p.next.val){
                int val = p.val;
                ListNode p2 = p;
                while(p2 != null && p2.val == val){
                    p2 = p2.next;
                }
                p.next = p2;
            }
            p = p.next;
        }
        return dummy.next;
    }
}