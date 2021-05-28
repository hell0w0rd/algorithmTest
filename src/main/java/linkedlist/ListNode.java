package linkedlist;

/**
 * Definition for singly-linked list.
 * public class linkedlist.ListNode {
 * int val;
 * linkedlist.ListNode next;
 * linkedlist.ListNode(int x) { val = x; }
 * }
 * @author max
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) {
        val = x;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
