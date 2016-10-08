// O(mn)
public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int[][] res = new int[grid.length][grid[0].length];
        int i, j;
        res[0][0] = grid[0][0];
        for (i = 1; i < grid.length; i++) {
            res[i][0] = grid[i][0] + res[i - 1][0];
        }
        for (i = 1; i < grid[0].length; i++) {
            res[0][i] = grid[0][i] + res[0][i - 1];
        }

        for (i = 1; i < grid.length; i++) {
            for (j = 1; j < grid[0].length; j++) {
                res[i][j] = res[i - 1][j] < res[i][j - 1] ? res[i - 1][j] : res[i][j - 1];
                res[i][j] += grid[i][j];
            }
        }
        return res[grid.length - 1][grid[0].length - 1];
    }
}
