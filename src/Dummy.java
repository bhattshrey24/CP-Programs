import java.util.*;

public class Dummy {
    public static void main(String args[]) {

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        boolean[][] visForPacific = new boolean[r][c];
        boolean[][] visForAtlantic = new boolean[r][c];

        for (int j = 0; j < c; j++) {
            if (!visForPacific[0][j]) {
                dfs(0, j, Integer.MIN_VALUE, r, c, visForPacific, heights);
            }
        }
        for (int i = 0; i < r; i++) {
            if (!visForPacific[i][0]) {
                dfs(i, 0, Integer.MIN_VALUE, r, c, visForPacific, heights);
            }
        }
        for (int j = 0; j < c; j++) {
            if (!visForAtlantic[r - 1][j]) {
                dfs(r - 1, j, Integer.MIN_VALUE, r, c, visForAtlantic, heights);
            }
        }
        for (int i = 0; i < r; i++) {
            if (!visForAtlantic[i][c - 1]) {
                dfs(i, c - 1, Integer.MIN_VALUE, r, c, visForAtlantic, heights);
            }
        }

        for (int i = 0; i < r; i++) {
            System.out.println();
            for (int j = 0; j < c; j++) {
                System.out.print(visForAtlantic[i][j]+" ");
            }
        }
        System.out.println();
        for (int i = 0; i < r; i++) {
            System.out.println();
            for (int j = 0; j < c; j++) {
                System.out.print(visForPacific[i][j]+" ");
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visForPacific[i][j] && visForAtlantic[i][j]) {
                    ArrayList<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    ans.add(curr);
                }
            }
        }
        return ans;
    }

    public static void dfs(int i, int j, int prev, int r, int c, boolean[][] vis, int[][] heights) {
        if (!isValid(i, j, r, c)) return;
        if (vis[i][j]) return;
        if (heights[i][j] < prev) return;

        vis[i][j] = true;

        dfs(i + 1, j, heights[i][j], r, c, vis, heights);
        dfs(i - 1, j, heights[i][j], r, c, vis, heights);
        dfs(i, j + 1, heights[i][j], r, c, vis, heights);
        dfs(i, j - 1, heights[i][j], r, c, vis, heights);
    }
    public static boolean isValid(int i, int j, int r, int c) {
        return (i >= 0 && j >= 0) && (i < r && j < c);
    }


}