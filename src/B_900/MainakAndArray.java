package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainakAndArray {
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
            mainakAndArray(arr, n);
        }
    }

    public static void mainakAndArray(int[] arr, int n) {
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int max1 = Integer.MIN_VALUE; // calculates the max when l = a1 and r = an
        int maxFrom1toLast = Integer.MIN_VALUE;
        int minFrom1st = arr[0];
        Math.max(max1, arr[n - 1] - arr[0]);
        for (int i = 1; i < arr.length; i++) {
            max1 = Math.max(max1, arr[i - 1] - arr[i]);
            maxFrom1toLast = Math.max(arr[i], maxFrom1toLast);
            minFrom1st = Math.min(arr[i], minFrom1st);
        }
        int max2 = arr[n - 1] - minFrom1st; // max when l = a2 and r = an
        int max3 = maxFrom1toLast - arr[0];// max when l = a1 and r = an-1
        System.out.println(Math.max(max1, Math.max(max2, max3)));
    }
}