import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        int length = 0;
        ListNode temp = head;

        while(temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode newTemp;
        int ptr = 0;
        temp = head;

        ListNode newHead = new ListNode(0);
        while(ptr < length/ 2) {
            ListNode tmp = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = tmp;
            ptr++;
        }

        while(ptr++ < length - length/ 2) {
            temp = temp.next;
        }

        newTemp = temp;
        temp = newHead.next;

        while(newTemp != null) {
            if (temp.val != newTemp.val)
                return false;
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return true;
    }
}