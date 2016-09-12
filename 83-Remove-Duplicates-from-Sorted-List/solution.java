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
        ListNode dummy = new ListNode(head.val + 1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while(cur != null){
            if(cur.val == pre.val){
                int val = cur.val;
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}