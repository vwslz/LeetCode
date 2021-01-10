public class RangeSumQuery2DImmutable_304 {
    private int[][] sums;
    public RangeSumQuery2DImmutable_304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        sums = new int[matrix.length+1][matrix[0].length+1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sums[i+1][j+1] = sums[i+1][j] + sums[i][j+1] - sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
    }
}
