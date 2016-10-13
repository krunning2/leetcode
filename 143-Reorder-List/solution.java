/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = getMid(head);
        ListNode newHead = mid.next;
        mid.next = null;
        newHead = reverse(newHead);
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(head != null && newHead != null){
            p.next = head;
            head = head.next;
            p = p.next;
            p.next = newHead;
            p = p.next;
            newHead = newHead.next;
        }
        if(head != null) p.next = head;
    }
    
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    private ListNode getMid(ListNode head){
        ListNode fast = head, slow = head;
        while(true){
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            slow = slow.next;
        }
        return slow;
    }
}