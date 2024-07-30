package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BalancedRound {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            line = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            balancedRound(arr, k, n);
        }
    }
    // This question is Giving TLE because of Java. otherwise it is the fastest solution

    public static void balancedRound(int[] arr, int k, int n) {
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int ele : arr) {
            mn = Math.min(mn, ele);
            mx = Math.max(mx, ele);
        }
        if (mx - mn <= k) { // Just trying to make it a bit faster
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        int max = 0;
        int curr = 0;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff > k) {
                curr = 0;
                continue;
            }
            curr++;
            max = Math.max(max, curr);
        }
        max = n - max - 1;
        System.out.println(max);
    }

}
