/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);
        for(ListNode l : lists){
            if(l != null){
                queue.offer(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(!queue.isEmpty()){
            ListNode cur = queue.poll();
            p.next = cur;
            if(cur.next != null){
                queue.offer(cur.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}