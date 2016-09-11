/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        return merge(left, right);
    }
    
    
    private ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return dummy.next;
    }
}