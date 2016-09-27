// O(n)
public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode iter = newHead;
        while (iter.next != null) {
            if (iter.next.next != null) {
                ListNode temp = iter.next.next;
                iter.next.next = temp.next;
                temp.next = iter.next;
                iter.next = temp;
                iter = temp.next;
            }
            else
                iter = iter.next;
        }
        return newHead.next;
    }

}
