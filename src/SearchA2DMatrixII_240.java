public class SearchA2DMatrixII_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null
                || matrix.length == 0
                || matrix[0].length == 0
                || target < matrix[0][0]
                || target > matrix[matrix.length-1][matrix[0].length-1]
        )
            return false;

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0 ) {
            if (target == matrix[row][col])
                return true;
            else if (target > matrix[row][col])
                row++;
            else
                col--;
        }
        return false;
    }
}
