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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode current = head;
        ListNode Next = null;

        while (current != null) {
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = reverseList(l1);
        ListNode temp2 = reverseList(l2);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        
        while (temp1 != null || temp2 != null) {
            int val1 = 0, val2 = 0;
            if (temp1 != null) val1 = temp1.val;
            if (temp2 != null) val2 = temp2.val;
            int num = carry + val1 + val2;
            ListNode ans = new ListNode(num%10);
            temp.next = ans;
            temp = temp.next;
            if (num > 9) carry = 1;
            else carry = 0;
            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;   
        }

        if (carry == 1) {
            ListNode ans = new ListNode(1);
            temp.next = ans;
            temp = temp.next;
        }
        
        return reverseList(dummy.next);
    }
}