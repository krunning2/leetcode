/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode p = head;
        int count = 1;
        while(p != null && p.next != null){
            p = p.next;
            count ++;
        }
        p.next = head;
        k = k % count;
        for(int i = 0; i < count - k; i++){
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        return newHead;
    }
}