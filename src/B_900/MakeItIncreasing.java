package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeItIncreasing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            makeItIncreasing(arr, n);
        }
    }

    public static void makeItIncreasing(int[] arr, int n) {
        double ans = 0;
        double prev = arr[n - 1];
        double curr;
        for (int i = n - 2; i >= 0; i--) {
            curr = arr[i];
            if (curr < prev) {
                prev = curr;
            } else {
                while (curr > 0 && curr >= prev) {
                    curr = Math.floor(curr / 2);
                    ans++;
                }
                if (curr == 0 && prev == 0) {
                    System.out.println(-1);
                    return;
                }
                prev = curr;
            }
        }
        System.out.println((int) ans);
    }
}
