public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1') {
                    numIslandsHelper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void numIslandsHelper(char[][] grid, int row, int col)
    {
        if (grid[row][col] == '1')
            grid[row][col] = '0';
        else
            return;
        if(row > 0)
            numIslandsHelper(grid, row - 1, col);
        if(col > 0)
            numIslandsHelper(grid, row, col - 1);
        if(row < grid.length - 1)
            numIslandsHelper(grid, row + 1, col);
        if(col < grid[0].length - 1)
            numIslandsHelper(grid, row, col + 1);
    }
}
