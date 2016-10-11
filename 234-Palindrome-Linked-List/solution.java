/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode mid = getMid(head);
        
        ListNode next = mid.next;
        mid.next = null;
        ListNode reversed = reverse(next);
        ListNode p1 = reversed;
        ListNode p2 = head;
        while(p1 != null){
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    private ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            fast = fast.next;
            if(fast == null) return slow;
            fast = fast.next;
            if(fast == null) return slow;
            slow = slow.next;
        }
    }
}