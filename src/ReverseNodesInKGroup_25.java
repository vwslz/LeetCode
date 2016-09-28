// O(n)
public class ReverseNodesInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        ListNode iter = head, iterNewHead = newHead, temp;
        while (iter != null) {
            temp = iter;
            int j = k;
            while (j-- > 0) {
                if (temp != null)
                    temp = temp.next;
                else {
                    iterNewHead.next = iter;
                    return newHead.next;
                }
            }
            iterNewHead = reverseK(iter, k, iterNewHead);
            iter = temp;
        }
        return newHead.next;
    }

    public  ListNode reverseK(ListNode head, int k, ListNode iterNewHead) {
        ListNode iter = head;
        while (k-- > 0) {
            ListNode node = iter;
            iter = iter.next;
            node.next = iterNewHead.next;
            iterNewHead.next = node;
        }
        return head;
    }
}
