// O(n)
public class IntersectionOfTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode iter1 = headA;
        ListNode iter2 = headB;
        while (iter1 != iter2)
        {
            if (iter1 == null)
                iter1 = headB;
            else
                iter1 = iter1.next;

            if (iter2 == null)
                iter2 = headA;
            else
                iter2 = iter2.next;
        }
        return iter1;
    }
}
