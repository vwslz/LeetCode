import java.util.Hashtable;

// O(n)

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(target - nums[i])) {
                return new int[]{ht.get(target - nums[i]), i};
            } else ht.put(nums[i], i);
        }
        return null;
    }
}
