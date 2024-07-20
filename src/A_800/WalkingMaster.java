package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WalkingMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            int d = Integer.parseInt(line[3]);
            walkingMaster(a, b, c, d);
        }
    }

    // It's a geometry related question so just draw the test
    // cases on a page and see how you can find the answer.
    // Basically the logic I used is we go back from (a,b) on same x axis until slop becomes 1 and
    // when slop becomes 1 then we can reach (c,d) using (x+1,y+1) move i.e. moving diagonally upwards
    public static void walkingMaster(int a, int b, int c, int d) {
        if (a == c && b == d) { // i.e. points are same
            System.out.println(0);
            return;
        }

        double slope = (c * 1.0 - a) / (d * 1.0 - b); // think in terms of slope i.e.
        // if slope > 45 i.e. > 1 then we can never reach (c,d) from point (a,b)
        if (slope > 1.0 || d < b) { // since we can only move back in same x axis of diagonally
            // up therefore if c,d lies below a,b then there is no way we can
            // reach c,d from a,b with given valid moves
            System.out.println(-1);
        } else {
            int x = d - b - c + a; // this is derived by drawing i.e. I drew a 2d plane and just tried to find
            // answer for t1 : a = 2  b = 3 , c = 6  d = 5 and
            // t2 : a = -2 b = -3  , c = -5  d = 6
            int ans = x;
            a = a - x;
            ans += c - a; // we are trying to make c - a = d - b because then
            // only slop will be 1 i.e. 45 degree and we will be able to reach the c,d
            System.out.println(ans);
        }

    }
}
