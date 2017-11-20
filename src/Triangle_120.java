import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int size = triangle.size();
        int[] res = new int[size];
        res[0] = triangle.get(0).get(0);
        for (int i = 1; i < size - 1; i++) {
            res[i] = triangle.get(i).get(i) + res[i-1];
            for (int j = i - 1; j > 0; j--) {
                res[j] = triangle.get(i).get(j) + (res[j-1] < res[j] ? res[j-1] : res[j]);
            }
            res[0] = triangle.get(i).get(0) + res[0];
        }
        res[size-1] = triangle.get(size-1).get(size-1) + res[size-2];
        for (int j = size - 2; j > 0; j--) {
            res[j] = triangle.get(size - 1).get(j) + (res[j - 1] < res[j] ? res[j - 1] : res[j]);
            if (res[j] < res[size - 1])
                res[size - 1] = res[j];
        }
        if (triangle.get(size-1).get(0) + res[0] < res[size-1]) res[size-1] = triangle.get(size-1).get(0) + res[0];
        return res[size-1];
    }
}
