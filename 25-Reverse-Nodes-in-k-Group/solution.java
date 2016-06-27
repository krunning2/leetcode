/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        int len = 0;
        while(p != null){
            len ++;
            p = p.next;
        }
        ListNode pre = dummy;
        p = head;
        ListNode h = dummy;
        ListNode n = head;
        for(int i = 0; i < len / k; i++){
            for(int j = 0; j < k; j++){
                ListNode next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            h.next = pre;
            n.next = p;
            h = n;
            n = p;
        }
        return dummy.next;
    }
}