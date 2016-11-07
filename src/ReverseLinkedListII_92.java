// O(n)
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode res = pre;
        for(int i = 1; i < m; i++)
            pre = pre.next;
        ListNode iter = pre.next;
        for(int i = m; i < n; i++){
            ListNode tmp = pre.next;
            pre.next = iter.next;
            iter.next = pre.next.next;
            pre.next.next = tmp;
        }

        return res.next;
    }
}
