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
        ListNode cur = head;
        // dummy.next = head;
        while(cur != null){
            ListNode pre = findInsertLocation(dummy, cur.val);
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }
    private ListNode findInsertLocation(ListNode node, int val){
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null && cur.val <= val){
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
}