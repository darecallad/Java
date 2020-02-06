package LeetCode;

public class RemoveDuplicatesfromSortedList {
    //Given a sorted linked list, delete all duplicates such that each element appear only once.
    //
    //Example 1:
    //
    //Input: 1->1->2
    //Output: 1->2
    //Example 2:
    //
    //Input: 1->1->2->3->3
    //Output: 1->2->3
    private class ListNode{
        int value;
        ListNode next;
        ListNode(int x){
            this.value = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        var current = head;
        while(current != null && current.next != null){
            if(current.value == current.next.value)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return  head;

    }
}
