public class DungeonGame_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int numRow = dungeon.length;
        int numCol = dungeon[0].length;
        dungeon[numRow - 1][numCol - 1] = (dungeon[numRow - 1][numCol - 1] <= 0 ? - dungeon[numRow - 1][numCol - 1] + 1 : 1);

        for (int i = numRow - 2; i >= 0; i--) {
            dungeon[i][numCol - 1] = dungeon[i + 1][numCol - 1] - dungeon[i][numCol - 1];
            if (dungeon[i][numCol - 1] <= 0)
                dungeon[i][numCol - 1] = 1;
        }
        for (int i = numCol - 2; i >= 0; i--)
        {
            dungeon[numRow - 1][i] = dungeon[numRow - 1][i + 1] - dungeon[numRow - 1][i];
            if (dungeon[numRow - 1][i] <= 0)
                dungeon[numRow - 1][i] = 1;
        }
        for (int i = numRow - 2; i >= 0; i--)
        {
            for (int j = numCol - 2; j >= 0; j--)
            {
                if (dungeon[i + 1][j] - dungeon[i][j] <= 0 || dungeon[i][j + 1] - dungeon[i][j] <= 0)
                    dungeon[i][j] = 1;
                else if (dungeon[i + 1][j] - dungeon[i][j] < dungeon[i][j + 1] - dungeon[i][j])
                    dungeon[i][j] = dungeon[i + 1][j] - dungeon[i][j];
                else
                    dungeon[i][j] = dungeon[i][j + 1] - dungeon[i][j];
            }
        }

        return dungeon[0][0];
    }
}
