import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII_80 sol= new RemoveDuplicatesFromSortedArrayII_80();

        // Helper class
        Helpers h = new Helpers();
        // int arr
        int[] test = new int[] {1,1,1,2,2,3};
        // int arr arr
//        int[][] test = new int[4][3];
//        test[0][0] = 0;
//        test[0][1] = 1;
//        test[0][2] = 2;
//        test[1][0] = 3;
//        test[1][1] = 4;
//        test[1][2] = 5;
//        test[2][0] = 0;
//        test[2][1] = 6;
//        test[2][2] = 7;
//        test[3][0] = 0;
//        test[3][1] = 0;
//        test[3][2] = 0;
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

        // String array
//        String[] test = new String[]{"What", "must", "be", "shall", "be."};

//        sol.setZeroes(test);
        System.out.println(sol.removeDuplicates(test));
        h.printIntegerArray(test);

//        System.out.println(sol.minWindow("a", "a"));
    }
}


