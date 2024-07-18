package A_800;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetPractice {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[][] board = new char[10][10];
            for (int i = 0; i < 10; i++) {
                String line = br.readLine();
                for (int j = 0; j < 10; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
            targetPractice(board, 9);
        }
    }

    // Just write down cells for each point like for point 1 which cells are needed to be traversed
    // you will see a pattern
    public static void targetPractice(char[][] board, int n) {
        int ans = 0;
        int points = 1;
        int l = (int) Math.ceil((n * 1.0) / 2);
        for (int k = 0; k < l; k++) {
            for (int i = k; i <= (n - k); i++) {
                int j1 = k, j2 = n - k;
                if (i == k || i == (n - k)) { // if first and last row then simply traverse from j1 to j2
                    for (int j = j1; j <= j2; j++) {
                        if (board[i][j] == 'X') {
                            ans += points;
                        }
                    }
                    continue;
                }
                if (board[i][j1] == 'X') { // else simply check vertical border elements of that sqaure
                    ans += points;
                }
                if (board[i][j2] == 'X') {
                    ans += points;
                }
            }
            points++;
        }
        System.out.println(ans);
    }
}
