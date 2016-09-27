// O(n)
public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode head1 = newHead;
        ListNode head2 = newHead;
        while (head1.next != null) {
            if (n <= 0)
                head2 = head2.next;
            head1 = head1.next;
            n--;
        }
        if (head2.next != null) {
            head2.next = head2.next.next;
        }
        return newHead.next;
    }
}
