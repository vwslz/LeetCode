// O(n*log(k))
public class MergeKSortedLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)   return null;
        int i = 0;
        int j = lists.length - 1;
        while (i < j) {
            lists[i] = mergeTwo(lists[i++], lists[j--]);
            if (i >= j) {
                if (j != 0) i = 0;
            }
        }
        return lists[0];
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode iterNewHead = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iterNewHead.next = l1;
                l1 = l1.next;
            } else {
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