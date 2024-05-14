package Matrix;

class Solution {
    int delta[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0)
            return 0;
        int temp = grid[x][y], ans = 0;
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int X = x + delta[i][0];
            int Y = y + delta[i][1];
            ans = Math.max(ans, temp + dfs(grid, X, Y));
        }
        grid[x][y] = temp;
        return ans;
    }
}

public class Path_with_Maximum_Gold {

}
