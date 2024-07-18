package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// It's quite simple i.e. if both are playing optimally then if
// number is divisible by 3 then first wins else second player wins
public class GameWithInteger {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            game(n);
        }
    }

    public static void game(int n) {
        if (n % 3 != 0) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }
    }
}
