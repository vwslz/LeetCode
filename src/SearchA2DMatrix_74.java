// O(log n)
public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
            return false;
        int col = binaryCol(matrix, target);
        System.out.println(col);
        return binaryRow(matrix, target, col);
    }

    public int binaryCol(int[][] matrix, int target) {
        int sta = 0, end = matrix.length - 1;
        while (sta < end) {
            int med = end - (end - sta) / 2;
            if (matrix[med][0] == target)
                return med;
            else if(matrix[med][0] > target)
                end = med - 1;
            else {
                sta = med;
            }
        }
        return sta;
    }

    public boolean binaryRow(int[][] matrix, int target, int row) {
        int left = 0, right = matrix[0].length - 1;
        while (left <= right) {
            int med = (right + left) / 2;
            if (matrix[row][med] == target)
                return true;
            else if (matrix[row][med] < target)
                left = med + 1;
            else
                right = med - 1;
        }
        return false;
    }
}
