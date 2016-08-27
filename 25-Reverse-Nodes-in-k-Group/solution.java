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
        if(head == null || k < 0){
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        cur = dummy;
        ListNode next = head;
        for(int i = 0; i < len / k ; i++){
            for(int j = 0; j < k; j++){
                ListNode tmp = next.next;
                next.next = cur;
                cur = next;
                next = tmp;
            }
            ListNode tmp = pre.next;
            pre.next.next = next;
            pre.next = cur;
            pre = tmp;
            cur = tmp;
        }
        return dummy.next;
    }
}