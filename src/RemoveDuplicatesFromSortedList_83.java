// O(n)
public class RemoveDuplicatesFromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)   return head;
        ListNode newHead = new ListNode(head.val - 1);
        ListNode iter = head;
        ListNode pre = newHead;
        while (iter != null) {
            if (iter.val != pre.val) {
                pre.next = iter;
                pre = pre.next;
            }
            iter = iter.next;
        }
        pre.next = null;
        return newHead.next;
    }
}
