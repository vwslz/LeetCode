public class FindSmallestCommonElementInAllRows_1198 {
    public int smallestCommonElement(int[][] mat) {
        int[] idx = new int[mat.length];
        for (int i = 0; i < mat[0].length; i++) {
            idx[0] = i;
            int j = 1;
            while(j < mat.length) {
                while (idx[j] < mat[0].length) {
                    if (mat[j][idx[j]] < mat[0][i]) {
                        idx[j]++;
                    }
                    else if (mat[j][idx[j]] >= mat[0][i]) {
                        break;
                    }
                }
                if (idx[j] == mat[0].length)
                    return -1;

                if (mat[j][idx[j]] > mat[0][i]) {
                    break;
                }
                j++;
            }
            if (j == mat.length) {
                return mat[0][i];
            }
        }
        return -1;
    }
}
