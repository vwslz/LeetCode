public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;

        ListNode iter = newHead;
        while(iter.next != null){
            ListNode next = iter.next.next;
            if(insert(iter.next, newHead)){
                iter.next = next;
            }
            else
                iter = iter.next;
        }
        return newHead.next;
    }

    public boolean insert(ListNode node, ListNode newHead){
        ListNode iter = newHead;
        while(iter.next != null && iter.next != node){
            if(iter.next.val >= node.val){
                node.next = iter.next;
                iter.next = node;
                return true;
            }
            iter = iter.next;
        }
        return false;
    }
}
