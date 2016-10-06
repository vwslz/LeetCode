import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SpiralMatrix_54 sol = new SpiralMatrix_54();

        // Helper class
        Helpers h = new Helpers();
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

        // String array
//        String[] test = new String[]{"eat", "tan", "tea", "ate", "nat", "bat"};
        int[][] test = new int[4][3];
        test[0][0] = 1; test[0][1] = 2; test[0][2] = 3;
        test[1][0] = 4; test[1][1] = 5; test[1][2] = 6;
        test[2][0] = 7; test[2][1] = 8; test[2][2] = 9;
        test[3][0] = 10; test[3][1] = 11; test[3][2] = 12;
        h.printIntegerList(sol.spiralOrder(test));
    }

}


