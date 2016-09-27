// O(n)
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode iterNewHead = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iterNewHead.next = l1;
                l1 = l1.next;
            }
            else {
                iterNewHead.next = l2;
                l2 = l2.next;
            }
            iterNewHead = iterNewHead.next;
        }
        if (l1 != null)
            iterNewHead.next = l1;
        if (l2 != null)
            iterNewHead.next = l2;
        return newHead.next;
    }
}
