import java.util.ArrayList;
import java.util.List;

// O(mn)
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0)    return res;
        int top = -1, bottom = matrix.length, left = -1, right = matrix.length;

    }
}
