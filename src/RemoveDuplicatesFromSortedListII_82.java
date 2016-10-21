// O(n)
public class RemoveDuplicatesFromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)   return head;
        ListNode newHead = new ListNode(head.val - 1);
        ListNode iter = head;
        ListNode pre = newHead;
        while (iter != null) {
            if (iter.next != null && iter.val == iter.next.val) {
                iter = findNext(iter);
            }
            else {
                pre.next = iter;
                pre = pre.next;
                iter = iter.next;
            }
        }
        pre.next = null;
        return newHead.next;
    }

    public ListNode findNext(ListNode head) {
        int val = head.val;
        while (head.next != null) {
            if (head.next.val == val) {
                head = head.next;
            }
            else {
                return head.next;
            }
        }
        return null;
    }
}
