/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        while(cur != null){
            ListNode pre = findPosition(dummy, cur.val);
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }
    private ListNode findPosition(ListNode head, int val){
        ListNode pre = null, cur = head;
        while(cur != null && cur.val <= val){
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
}