package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtremelyRound {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            extremelyRound(n);
        }
    }

    // Just think greedy.
    // see we find biggest (10 power x) divisor of n like for 43532 the  biggest
    // divisor is 10000 so we find how many such we can fit so here it
    // is 4 i.e. 10000 , 20000, 30000,40000 .  Then simply add 9 digits to it i.e. digit 1 - 9 will also be in answer
    // and rest sbke 9 i.e. 1000 ke 9 i.e. 1000,2000...9000 and 100 ke 9 i.e. 100,200...900 and 10 ke 9 i.e. 10,20,...90
    public static void extremelyRound(int n) {
        if (n <= 9) {
            System.out.println(n);
            return;
        }
        int temp = n;
        int count = 0;
        while (temp > 0) {
            temp = temp / 10;
            count++;
        }
        int divisor10 = (int) Math.pow(10, count - 1);
        int x = n / divisor10;
        int ans = 9 + x;
        if (count - 2 > 0) {
            ans += (count - 2) * 9;
        }
        System.out.println(ans);
    }
}
