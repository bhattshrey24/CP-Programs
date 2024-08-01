import java.util.*;

public class Dummy {
    public static void main(String args[]) {
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int[][] vis;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                vis = new int[r][c];
                int dfsAns = dfs(i, j, Integer.MAX_VALUE, r, c, heights, vis);
                System.out.println(dfsAns);
                if (dfsAns == 2) {
                    ArrayList<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    ans.add(curr);
                }
            }
        }
        return ans;
    }

    public static int dfs(int i, int j, int prev, int r, int c, int[][] heights, int[][] vis) {
        System.out.println(i + " " + j + " " + prev);
        // base case 1 i.e. current cell is out of bound;
        if (i < 0 || j < 0) {
            return 1; // Pacific
        }
        if (i >= r || j >= c) {
            return 2; // Atlantic
        }
        if (prev < heights[i][j]) {
            return 4; // cannot go here
        }

        if (vis[i][j] != 0) return vis[i][j];// base case 2 i.e. current cell is visited

        vis[i][j] = 4;

        int down = dfs(i + 1, j, heights[i][j], r, c, heights, vis);
        int up = dfs(i - 1, j, heights[i][j], r, c, heights, vis);
        int right = dfs(i, j + 1, heights[i][j], r, c, heights, vis);
        int left = dfs(i, j - 1, heights[i][j], r, c, heights, vis);

        if ((down == 1 || up == 1 || right == 1 || left == 1) && (down == 2 || up == 2 || right == 2 || left == 2)) {
            vis[i][j] = 3;
            return 3;
        } else if (down == 3 || up == 3 || right == 3 || left == 3) {
            vis[i][j] = 3;
            return 3;
        } else if (down == 1 || up == 1 || right == 1 || left == 1) {
            vis[i][j] = 1;
            return 1;
        } else if (down == 2 || up == 2 || right == 2 || left == 2) {
            vis[i][j] = 2;
            return 2;
        } else {
            vis[i][j] = 4;
            return 4;
        }
    }

}
