import java.util.*;

public class RangeSumQueryMutable_307 {
    // Solution 3: Use segment tree
    // O(log n)
    private int[] nums;
    private int[] segmentTree;
    public RangeSumQueryMutable_307(int[] nums) {
        if (nums.length == 0)
            return;
        this.nums = nums;
        segmentTree = new int[4*nums.length];
        constructTree(nums, 0, nums.length - 1, 0);
    }

    public int constructTree(int[] nums, int left, int right, int index) {
        if (left == right)
            segmentTree[index] = nums[left];
        else {
            int middle = (left + right) / 2;
            segmentTree[index] = constructTree(nums, left, middle, 2 * index + 1)
                    + constructTree(nums, middle + 1, right, 2 * index + 2);
        }
        return segmentTree[index];
    }

    public void updateTree(int i, int val, int left, int right, int index) {
        segmentTree[index] += val;
        if (left != right) {
            int middle = (left + right) / 2;
            if (i <= middle)
                updateTree(i, val, left, middle, 2 * index + 1);
            else
                updateTree(i, val, middle + 1, right, 2 * index + 2);
        }
    }

    public int getSum(int i_left, int i_right, int left, int right, int index) {
        if (i_left > i_right)
            return 0;
        else if (i_left == left && i_right == right)
            return segmentTree[index];

        int middle = (left + right) / 2;
        return getSum(i_left, Math.min(i_right, middle), left, middle, 2 * index + 1) +
        getSum(Math.max(i_left, middle), i_right, middle+1, right, 2 * index + 2);
    }

    public void update(int i, int val) {
        updateTree(i, val- nums[i], 0, nums.length - 1, 0);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return getSum(i, j, 0, nums.length - 1, 0);
    }


//    // Solution 2
//    // m queries and n numbers
//    // m/2 update queries, m/2 sum queries
//    // O(mn): lazy updates to update sum for each consecutive sum queries
//    private int[] nums;
//    private int[] sums;
//    boolean updated = false;
//    int i_to_update;
//    public RangeSumQueryMutable_307(int[] nums) {
//        sums = new int[nums.length + 1];
//        this.nums = nums;
//        i_to_update = 0;
//        getSum();
//    }
//
//    public void update(int i, int val) {
//        nums[i] = val;
//        updated = true;
//        if (i < i_to_update)
//            i_to_update = i;
//    }
//
//    public void getSum() {
//        sums[0] = 0;
//        for (int i = i_to_update; i < nums.length; i++) {
//            sums[i + 1] = sums[i] + nums[i];
//        }
//        updated = false;
//        i_to_update = nums.length;
//    }
//
//    public int sumRange(int i, int j) {
//        if (updated)
//            getSum();
//        return sums[j+1]-sums[i];
//    }

    // Solution 1: Veru slow...
    //    private int[] sums;
    //    private HashMap<Integer, Integer> hm;
    //    public RangeSumQueryMutable_307(int[] nums) {
    //        sums = new int[nums.length + 1];
    //        hm = new HashMap<Integer, Integer>();
    //
    //        sums[0] = 0;
    //        for (int i = 0; i < nums.length; i++) {
    //            sums[i + 1] = sums[i] + nums[i];
    //        }
    //    }
    //
    //    public void update(int i, int val) {
    //        hm.put(i, val);
    //    }
    //
    //    public int sumRange(int i, int j) {
    //        if (hm.size() > 0) {
    //            hm.put(sums.length - 1, 0);
    //            int diff = 0;
    //            int i_pre = -1;
    //
    //            ArrayList<Integer> sortedKeys =
    //                    new ArrayList<Integer>(hm.keySet());
    //
    //            Collections.sort(sortedKeys);
    //
    //            for (int k : sortedKeys) {
    //                if (i_pre == -1) {
    //                    diff = hm.get(k) - (sums[i+1] - sums[i]);
    //                }
    //                else {
    //                    int newDiff = hm.get(k) - (sums[i+1] - sums[i]);
    //                    if (diff != 0) {
    //                        for (int l = i_pre; l < k; l++) {
    //                            sums[l + 1] += diff;
    //                        }
    //                    }
    //                    diff += newDiff;
    //                }
    //                i_pre = k;
    //            }
    //            hm.clear();
    //        }
    //
    //        return sums[j+1]-sums[i];
    //    }
}
