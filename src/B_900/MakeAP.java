package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeAP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            makeAP(a, b, c);
        }
    }

    public static void makeAP(int a, int b, int c) {
      // Critical test cases 1 1 4 , 1 1 1
        if ((b - a >= 0 && b + (b - a) == c) || (a - b >= 0 && b - (a - b) == c)) {
            System.out.println("Yes");
            return;
        }
        // check for starting ele
        if (c - b >= 0) {
            int d = c - b;
            int a2 = b - d;
            if (a2 > 0 && a2 % a == 0) {
                System.out.println("Yes");
                return;
            }

        }
        if (b - c >= 0) {
            int d = b - c;
            int a2 = b + d;
            if (a2 > 0 && a2 % a == 0) {
                System.out.println("Yes");
                return;
            }
        }
        // Checking for middle element
        if ((c - a) >= 0 && (c - a) % 2 == 0) {
            int d = (c - a) / 2;
            int b2 = a + d;
            if (b2 > 0 && b2 % b == 0) {
                System.out.println("Yes");
                return;
            }
        }
        if ((a - c) >= 0 && (a - c) % 2 == 0) {
            int d = (a - c) / 2;
            int b2 = c + d;
            if (b2 > 0 && b2 % b == 0) {
                System.out.println("Yes");
                return;
            }
        }
        // Checking End element
        if (b - a >= 0) {
            int d = b - a;
            int c2 = b + d;
            if (c2 > 0 && c2 % c == 0) {
                System.out.println("Yes");
                return;
            }
        }
        if (a - b >= 0) {
            int d = a - b;
            int c2 = b - d;
            if (c2 > 0 && c2 % c == 0) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
