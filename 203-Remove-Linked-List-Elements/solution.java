/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode p = head;
        while(p != null){
            if(p.val == val){
                p = p.next;
            }
            pre.next = p;
            pre = p;
            p = p.next;
        }
        return dummy.next;
    }
}