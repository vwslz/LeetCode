import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SearchForARange_34 sol = new SearchForARange_34();
//        int[] testcase = new int[] {2,7,11,51};
//        ListNode head = new ListNode(1);
//        ListNode iter = head;
//        int n = 1;
//        while (n++ <= 8) {
//            iter.next = new ListNode(n);
//            iter = iter.next;
//        }
//        iter = null;
//        String testcase = "jahkjfhahf";
//        System.out.println("" + sol.longestPalindrome(testcase));
        Helpers h = new Helpers();
//        h.printNodes(head);
//        h.printNodes(sol.reverseKGroup(head, 4));
        int[] test1 = new int[]{3,3,3};
//        int[] test2 = new int[]{0,1,3,6,7};
//        int[] test3 = new int[]{0,1,3,6,10,13,14};
//        int[] test4 = new int[]{0,1,2,3,4,8,9,11};
//        String test = "wordgoodgoodgoodbestword";
//        String[] words = new String[]{"word", "good", "best", "good"};
//        sol.nextPermutation(test1);
        h.printIntegerArray(sol.searchRange(test1, 3));
//        System.out.println(sol.search(test1, 6));
    }

}


