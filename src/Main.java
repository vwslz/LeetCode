import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Permutations_46 sol = new Permutations_46();
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
        int[] test = new int[]{1,2,3};

//        h.printListOfIntegerList(sol.combinationSum2(cans, 8));
        h.printListOfIntegerList(sol.permute(test));
    }

}


