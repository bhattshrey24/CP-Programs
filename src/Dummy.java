import java.util.*;

public class Dummy {
    public static void main(String args[]) {
        System.out.println(palindromeCount("1110"));
    }


    public int minFlips(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int countRow = 0;
        int countCol = 0;
        StringBuilder sb;
        int count1 = 0;
        for (int i = 0; i < r; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                sb.append(grid[i][j]);
                if (grid[i][j] == 1) {
                    count1++;
                }
            }
            countRow = countRow + palindromeCount(sb.toString());
        }
        for (int i = 0; i < c; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                sb.append(grid[j][i]);
            }
            countCol = countCol + palindromeCount(sb.toString());
        }
        int ans1 = countRow + Math.min((count1 + countRow) % 4, (count1 - countRow) % 4);
        int ans2 = countCol + Math.min((count1 + countCol) % 4, (count1 - countCol) % 4);

        return Math.min(ans1, ans2);
    }

    public static int palindromeCount(String str) {
        int i = 0;
        int j = str.length() - 1;
        int count = 0;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                count++;
            }
            i++;
            j--;
        }
        return count;
    }
}