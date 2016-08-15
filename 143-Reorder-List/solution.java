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
        ListNode next = mid.next;
        mid.next = null;
        ListNode newHead = reverse(next);
        merge(head, newHead);
    }
    
    private void merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(l1 != null && l2 != null){
            p.next = l1;
            l1 = l1.next;
            p = p.next;
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }
        if(l1 != null) p.next = l1;
    }
    
    private ListNode reverse(ListNode head){
        ListNode pre = null, cur = head;
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