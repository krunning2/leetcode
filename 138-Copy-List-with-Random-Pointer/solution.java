/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode p = head;
        // copy
        while(p != null){
            RandomListNode n = new RandomListNode(p.label);
            n.next = p.next;
            p.next = n;
            p = p.next.next;
        }
        // copy pointer
        p = head;
        while(p != null){
            if(p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        // decouple
        p = head;
        RandomListNode newHead = p.next;
        while(p != null && p.next != null){
            RandomListNode next = p.next;
            p.next = p.next.next;
            p = next;
        }
        return newHead;
    }
}