// O(n)
public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        int size = 0;
        for (int i = 0; i < k; i++) {
            if (fast.next != null)
                fast = fast.next;
            else {
                size = i + 1;
                break;
            }
        }
        if (size > 0) {
            size =  k % size;
            fast = head;
            for (int i = 0; i < size; i++) {
                fast = fast.next;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            ListNode res = slow.next;
            fast.next = head;
            slow.next = null;
            return res;
        }
        else
            return head;
    }
}
