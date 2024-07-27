package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestDivisorsInterval {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            longestDivisorsInterval(n);
        }
    }
    public static void longestDivisorsInterval(long n) {
        if(n%2!=0) {
            System.out.println(1);
            return;
        }
        int intervalLen = 0;
        for (long i = 1; i*i <= n; i++) {
            if (n % i != 0) {
                break;
            }
            intervalLen++;
        }
        System.out.println(intervalLen);
    }
}
