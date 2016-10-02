import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CombinationSumII_40 sol = new CombinationSumII_40();
        // int arr
//        int[] testcase = new int[] {2,7,11,51};
        // nodes
//        ListNode head = new ListNode(1);
//        ListNode iter = head;
//        int n = 1;
//        while (n++ <= 8) {
//            iter.next = new ListNode(n);
//            iter = iter.next;
//        }
//        iter = null;
        // String
//        String testcase = "jahkjfhahf";;
        // Helper class
        Helpers h = new Helpers();
        int[] cans = new int[]{10,1,2,7,6,1,5};

        h.printListOfIntegerList(sol.combinationSum2(cans, 8));
//        System.out.println(sol.);
    }

}


