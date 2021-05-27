/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  示例：
 *
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *  Related Topics 链表 数学
 */

class Solution2 {
    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        three.next = null;
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(4);
        four.next = five;
        five.next = six;
        six.next = null;
        System.out.print(addTwoNumbers(one, four).val+"->");
        System.out.print(addTwoNumbers(one, four).next.val+"->");
        System.out.println(addTwoNumbers(one, four).next.next.val);

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode curr = listNode;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return listNode.next;
    }
}
