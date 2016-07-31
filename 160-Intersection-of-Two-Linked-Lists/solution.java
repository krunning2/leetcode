/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode tailB = getTail(headB);
        tailB.next = headB;
        ListNode fast = headA;
        ListNode slow = headA;
        while(true){
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        if(fast == null){
            reset(tailB);
            return null;
        }
        slow = headA;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        reset(tailB);
        return fast;
    }
    private void reset(ListNode tail){
        tail.next = null;
    }
    private ListNode getTail(ListNode head){
        while(head != null && head.next != null){
            head = head.next;
        }
        return head;
    }
}