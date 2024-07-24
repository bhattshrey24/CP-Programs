package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Forked {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            line = br.readLine().split(" ");
            int xk = Integer.parseInt(line[0]);
            int yk = Integer.parseInt(line[1]);
            line = br.readLine().split(" ");
            int xq = Integer.parseInt(line[0]);
            int yq = Integer.parseInt(line[1]);
            int ans = forked(a, b, xk, yk, xq, yq, 2);
            System.out.println(ans);
        }
    }

    public static int forked(int a, int b, int xk, int yk, int xq, int yq, int count) { // The logic I used is that I start
        // from king and move in all possible directions and try to reach queen I used recursion because
        // I did not want to write all the cases but you can manually write all the possible cases
        if (count == 0) { // Base case : all possible moves exhausted
            if (xk == xq && yk == yq) { // Reached Queen
                return 1;
            } else {
                return 0;
            }
        }
        int call1 = forked(a, b, xk + a, yk + b, xq, yq, count - 1);
        int call2 = forked(a, b, xk + a, yk - b, xq, yq, count - 1);
        int call3 = forked(a, b, xk - a, yk + b, xq, yq, count - 1);
        int call4 = forked(a, b, xk - a, yk - b, xq, yq, count - 1);
        int call5 = 0, call6 = 0, call7 = 0, call8 = 0;
        if (a != b) { // This will stop us from doing duplicate calls
            call5 = forked(a, b, xk + b, yk + a, xq, yq, count - 1);
            call6 = forked(a, b, xk + b, yk - a, xq, yq, count - 1);
            call7 = forked(a, b, xk - b, yk + a, xq, yq, count - 1);
            call8 = forked(a, b, xk - b, yk - a, xq, yq, count - 1);
        }
        return call1 + call2 + call3 + call4 + call5 + call6 + call7 + call8;
    }

}
