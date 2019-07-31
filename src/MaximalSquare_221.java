
public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix.length == 0)
            return 0;
        int[][] resMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resMatrix[i][j] = matrix[i][j] - '0';
                if (i > 0 && j > 0 && matrix[i][j] == '1')
                    resMatrix[i][j] = minIn(resMatrix[i - 1][j], resMatrix[i][j - 1], resMatrix[i - 1][j - 1]) + 1;
                if (resMatrix[i][j] > res)
                    res = resMatrix[i][j];
            }
        }
        return res * res;
    }

    public int minIn(int a, int b, int c) {
        return minOf(minOf(a, b), c);
    }

    public int minOf(int a, int b) {
        return a > b ? b : a;
    }
}
