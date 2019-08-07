import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // O(kn) from https://leetcode.com/problems/sliding-window-maximum/discuss/351624/Java-1ms-O(1)-extra-space-solution-with-explanation
        // 2 ms
        if (nums.length == 0 || k == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        // Step 1: deal with the first window
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            maxVal = Math.max(nums[i], maxVal);
        }
        result[0] = maxVal;
        // Step 2: let's slide the window.
        for (int i = k; i < nums.length; i++) {
            int newVal = nums[i];
            if (newVal >= maxVal) {
                maxVal = newVal;
            } else if (nums[i - k] == maxVal) { // we are losing our maximum
                maxVal = newVal;
                for (int j = i - k + 1; j < i; j++) {
                    maxVal = Math.max(maxVal, nums[j]);
                }
            }
            result[i - k + 1] = maxVal;
        }
        return result;

//        // O(kn), worst case O(n^2)
//        // 5 ms, probably because need to edit one more variable
//        if (nums.length == 0) return new int[0];
//        int[] res = new int[nums.length - k + 1];
//        int maxVal = Integer.MIN_VALUE;
//        int maxIdx = -1;
//        for (int i = 0; i < k; i++) {
//            if (nums[i] > maxVal) {
//                maxVal = nums[i];
//                maxIdx = i;
//            }
//        }
//
//        res[0] = maxVal;
//
//        for (int i = k; i < nums.length; i++) {
//            if (nums[i] > maxVal) {
//                maxVal = nums[i];
//                maxIdx = i;
//            } else if (nums[i] == maxVal)
//                maxIdx = i;
//            else if (i - maxIdx > k) {
//                maxVal = nums[i];
//                for (int j = i - k + 1; j < i; j++) {
//                    if (nums[j] > maxVal)
//                        maxVal = nums[j];
//                }
//            }
//            res[i - k + 1] = maxVal;
//        }
//        return res;

//        // O(n), doubly linked list Deque in Java
//        // 9 ms
//        if(nums.length == 0) return new int[0];
//        int[] res = new int[nums.length - k + 1];
//        int index = 0;
//        Deque<Integer> deque = new LinkedList<>();
//        for(int i = 0; i < nums.length; i++){
//            while(!deque.isEmpty() && nums[i] > deque.getLast()){
//                deque.pollLast();
//            }
//            deque.add(nums[i]);
//            if (i >= k - 1) {
//                res[index++] = deque.getFirst();
//                if(deque.getFirst() == nums[i-k+1]){
//                    deque.pollFirst();
//                }
//            }
//        }
//        return res;

    }
}
