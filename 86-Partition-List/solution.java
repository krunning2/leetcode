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
        dummy.next = head;
        ListNode p = dummy;
        ListNode pre = p;
        while(p != null && p.val < x){
            pre = p;
            p = p.next;
        }
        
        ListNode p2 = pre;
        while(p != null){
            if(p.val >= x){
                p2 = p;
                p = p.next;
            }else{
                p2.next = p.next;
                p.next = pre.next;
                pre.next = p;
                pre = pre.next;
                p = p2.next;
            }
        }
        return dummy.next;
    }
}