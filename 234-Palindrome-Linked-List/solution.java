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
        ListNode mid = findMid(head);
        ListNode newHead = mid.next;
        mid.next = null;
        ListNode reversed = reverse(newHead);
        ListNode head2 = reversed;
        boolean flag = true;
        while(head2 != null){
            if(head2.val != head.val){
                flag = false;
                break;
            }
            head = head.next;
            head1 = head1.next;
        }
        head2 = reverse(reversed);
        mid.next = head2;
        return flag;
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
    private ListNode findMid(ListNode head){
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