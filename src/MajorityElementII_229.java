import java.util.ArrayList;
import java.util.List;

// O(n)
public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        int k = 3;

        int[] candidates = new int[k-1];
        int[] votes = new int[k-1];
        for (int num: nums) {
            boolean hasMatch = false;
            for (int i = 0; i < candidates.length; i++) {
                if (candidates[i] == num) {
                    votes[i]++;
                    hasMatch = true;
                    break;
                }
            }
            if (!hasMatch) {
                for (int i = 0; i < candidates.length; i++) {
                    if (votes[i] == 0) {
                        candidates[i] = num;
                        votes[i]++;
                        hasMatch = true;
                        break;
                    }
                }
            }
            if (!hasMatch) {
                for (int i = 0; i < votes.length; i++) {
                    votes[i]--;
                }
            }
        }

        // Varifiy
        for (int i = 0; i < votes.length; i++) {
            votes[i] = 0;
        }
        for (int num: nums) {
            for (int i = 0; i < candidates.length; i++) {
                if (num == candidates[i]) {
                    votes[i]++;
                    break;
                }
            }
        }

        for (int i = 0; i < candidates.length; i++) {
            if (votes[i] > nums.length / k)
                res.add(candidates[i]);
        }
        return res;
    }
}