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
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        int len = 1;
        while(p != null && p.next != null){
            p = p.next;
            len ++;
        }
        k = k % len;
        p.next = head;
        for(int i = 0; i < len - k; i++){
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}