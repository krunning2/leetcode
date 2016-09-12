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
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        boolean flag = true;
        while(newHead != null && head != null){
            if(flag){
                p.next = head;
                head = head.next;
            }else{
                p.next = newHead;
                newHead = newHead.next;
            }
            p = p.next;
            flag = !flag;
        }
        if(head!=null) p.next = head;
        if(newHead!=null) p.next = newHead;
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