import java.util.*;

public class Dummy {
    public static void main(String args[]) {

    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, r, c, grid, visited); // one DFS call simply makes
                    // all the vertices in a connected component as true
                    count++;// Simply counting number of connected components
                }
            }
        }
        return count;
    }

    public static void dfs(int i, int j, int r, int c, char[][] grid, boolean[][] visited) {
        if (!isValid(i, j, r, c)) return;
        if (visited[i][j]) return;
        if (grid[i][j] == '0') return; // i.e. if current grid has water then return

        visited[i][j] = true;
        dfs(i + 1, j, r, c, grid, visited);
        dfs(i - 1, j, r, c, grid, visited);
        dfs(i, j + 1, r, c, grid, visited);
        dfs(i, j - 1, r, c, grid, visited);
    }

    public static boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && j >= 0 && i < r && j < c;
    }
}