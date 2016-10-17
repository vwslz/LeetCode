import java.util.Arrays;
import java.util.List;

public class Helpers {

    public void printNodes(ListNode head) {
        String res = "";
        while (head != null) {
            res += head.val + " ";
            head = head.next;
        }
        System.out.println(res);
    }

    public void printIntegerArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public void printArrayOfIntegerArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
                System.out.print(Arrays.toString(arr[i]));
        }
    }

    public void printArrayOfCharArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(String.valueOf(arr[i]));
    }

    public void printIntegerList(List<Integer> list) {
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i) + " ";
        }
        System.out.println(res);
    }

    public void printListOfIntegerList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(String.valueOf(list.get(i)));
        }
    }

    public void printListOfStringList(List<List<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size() - 1; j++) {
                System.out.print(list.get(i).get(j) + ", ");
            }
            System.out.print(list.get(i).get(list.get(i).size() - 1) + "\n");
        }
    }
}
