/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head.next == null || head.next.next == null) return head;
        ListNode node = head;
        int group = 1;

        while (node != null && node.next != null) {
            group++;
			
            int countNodes = 0;
            ListNode temp = node.next;
            while (temp != null && countNodes < group) {
                temp = temp.next;
                countNodes++;
            }
			
            if (countNodes % 2 == 0) {
                ListNode curr = node.next, prev = null, next = null;
                for (int i = 0; i < countNodes; i++) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                ListNode tail = node.next;
                tail.next = curr;
                node.next = prev;
                node = tail;
            } else {
                for (int i = 0; i < countNodes; i++) node = node.next;
            }
        }
        return head;
    }
}