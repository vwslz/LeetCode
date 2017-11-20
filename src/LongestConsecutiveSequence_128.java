import java.util.Hashtable;

// O(n)
public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>(nums.length);
        for (Integer n : nums) {
            if (!ht.containsKey(n)) {
                int left = 0;
                int right = 0;
                if (ht.containsKey(n - 1))
                    left = ht.get(n - 1);
                if (ht.containsKey(n + 1))
                    right = ht.get(n + 1);
                int length = left + 1 + right;

                ht.put(n, length);
                ht.put(n - left, length);
                ht.put(n + right, length);
                if (length > res)
                    res = length;
            }
        }
        return res;
    }
}
