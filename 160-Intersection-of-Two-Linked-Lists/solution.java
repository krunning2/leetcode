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
        ListNode tailB = getTail(headB);
        tailB.next = headB;
        ListNode fast = headA;
        ListNode slow = headA;
        while(true){
            if(fast == null) return null;
            fast = fast.next;
            if(fast == null) return null;
            fast = fast.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    private ListNode getTail(ListNode head){
        while(head != null && head.next != null){
            head = head.next;
        }
        return head;
    }
}