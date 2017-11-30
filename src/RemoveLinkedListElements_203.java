public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode new_head= new ListNode(0);
        new_head.next = head;
        ListNode iter = new_head;

        while(iter.next != null){
            if(iter.next.val == val){
                iter.next = iter.next.next;
            }
            else
                iter = iter.next;
        }

        return new_head.next;
    }
}
