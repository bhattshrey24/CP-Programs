package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Desorting {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String line[] = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            desorting(arr);
        }
    }

    public static void desorting(int arr[]) {
        boolean isSorted = true;
        int prev = arr[0];
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < prev) {
                isSorted = false;
                break;
            }
            minGap = Math.min(minGap, arr[i] - prev);
            prev = arr[i];
        }
        if (!isSorted) {
            System.out.println(0);
            return;
        }
        int ans = (minGap / 2) + 1;
        System.out.println(ans);
    }
}
