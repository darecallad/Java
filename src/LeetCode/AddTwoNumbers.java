package LeetCode;
//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Example:
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

public class AddTwoNumbers {
    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
    } // end ListNode class

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // we have different situation here, first L1 is longer than L2
        // second one of Ls is empty, and extra carry overflow
        ListNode dummyhead = new ListNode(0);
        var current = dummyhead;
        var carry = 0;

        while( l1 != null || l2 != null){
            // set x for l1 value and y for l2 value
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum /10;
            current.next = new ListNode( sum % 10); // first sum value
            current = current.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        // check for extra carry overflow
        if(carry > 0)
            current.next = new ListNode(carry);

        return dummyhead.next;
    }
}
