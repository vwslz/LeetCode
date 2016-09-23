// O(n)

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        ListNode res = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, iter=res;
        while (cur1!=null || cur2!=null) {
            if (cur1!=null) {
                carry+=cur1.val;
                cur1=cur1.next;
            }
            if (cur2!=null) {
                carry+=cur2.val;
                cur2=cur2.next;
            }
            iter.next = new ListNode(carry%10);
            iter = iter.next;
            carry /= 10;
        }
        if (carry == 1) iter.next=new ListNode(1);
        return res.next;
    }
}
