package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddGrasshopper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            long x = Long.parseLong(line[0]);
            long n = Long.parseLong(line[1]);
            oddGrasshopper(x, n);
        }
    }

    // It's purely observation based question and it might feel a bit tricky because you will
    //  have to dry run for a lot of examples inorder to see the pattern
    // so you can see this video :-https://www.youtube.com/watch?v=sY-g_0h5BrM
    // Hint is to run for atleast 16 steps and put those steps in 4*4 matrix like
    // 0,1,2,3 jumps in first row then 4,5,6,7 jump in next row and so on
    public static void oddGrasshopper(long x, long n) {
        long ans = 0;
        if (x % 2 == 0) {
            long d;
            if (n % 4 == 0) {
                d = 0;
            } else if (n % 4 == 1) {
                d = -1 * n;
            } else if (n % 4 == 2) {
                d = 1;
            } else {
                d = n + 1;
            }
            System.out.println(x + d);
        } else {
            long d;
            if (n % 4 == 0) {
                d = 0;
            } else if (n % 4 == 1) {
                d = n;
            } else if (n % 4 == 2) {
                d = -1;
            } else {
                d = -1 * (n + 1);
            }
            System.out.println(x + d);
        }
    }
}
