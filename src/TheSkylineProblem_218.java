// O(n^2)
import java.util.*;

public class TheSkylineProblem_218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> lefts = new ArrayList<>();
        List<List<Integer>> rights = new ArrayList<>();

        if (buildings.length == 0) {
            return lefts;
        }

        int index = 0;
        while (index < buildings.length)
        {
            int left = buildings[index][0];
            int right = buildings[index][1];
            int height = buildings[index][2];

            index++;

            if (rights.size() == 0) {
                lefts.add(Arrays.asList(left, height));
                rights.add(Arrays.asList(right, height));
                continue;
            }

            while (rights.size() > 0 && rights.get(0).get(0) < left) {
                if (rights.size() > 1)
                    lefts.add(Arrays.asList(rights.get(0).get(0), rights.get(1).get(1)));
                else
                    lefts.add(Arrays.asList(rights.get(0).get(0), 0));
                rights.remove(0);
            }
            if (rights.size() == 0) {
                index--;
                continue;

            }

            if (height > rights.get(0).get(1)) {
                if (left == lefts.get(lefts.size() - 1).get(0))
                    lefts.set(lefts.size() - 1, Arrays.asList(left, height));
                else if (left <= rights.get(0).get(0))
                    lefts.add(Arrays.asList(left, height));
            }

            int idx = 0;
            while (idx < rights.size()) {
                if (right <= rights.get(idx).get(0)) {
                    if (height > rights.get(idx).get(1)) {
                        if (right == rights.get(idx).get(0))
                            rights.set(idx, Arrays.asList(right, height));
                        else
                            rights.add(idx, Arrays.asList(right, height));
                    }
                    break;
                }
                else {
                    if (height > rights.get(idx).get(1))
                        rights.remove(idx);
                    else if (height == rights.get(idx).get(1))
                        rights.set(idx, Arrays.asList(right, height));
                    else {
                        idx++;
                    }
                }
            }
            if (idx == rights.size())
                rights.add(idx, Arrays.asList(right, height));
        }

        int left = rights.get(0).get(0);
        rights.remove(0);
        while (rights.size() > 0) {
            lefts.add(Arrays.asList(left, rights.get(0).get(1)));
            left = rights.get(0).get(0);
            rights.remove(0);
        }
        lefts.add(Arrays.asList(left, 0));

        return lefts;
    }

}
