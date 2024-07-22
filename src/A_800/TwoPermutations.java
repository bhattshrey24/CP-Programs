package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoPermutations {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            twoPermutations(n, a, b);
        }
    }

    public static void twoPermutations(int n, int a, int b) {
        if (n == a && a == b) {// Edge case : 3,3,3 the answer is true I don't know why
            System.out.println("Yes");
            return;
        }
        if (n - (a + b) >= 2) { // i.e.agar 2 ka gap hai toh ho jaega because
            // same permutation rakho bus un dono ko swap krdo eg : -
            // p = 1234567
            // q = 1235467
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
