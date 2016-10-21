// O(n)
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode leftHead = new ListNode(0), rightHead = new ListNode(0),
                leftIter = leftHead, rightIter = rightHead;
        while (head != null) {
            if (head.val < x) {
                leftIter.next = head;
                leftIter = leftIter.next;
            }
            else {
                rightIter.next = head;
                rightIter = rightIter.next;
            }
            head = head.next;
        }
        leftIter.next = rightHead.next;
        rightIter.next = null;
        return leftHead.next;
    }
}
