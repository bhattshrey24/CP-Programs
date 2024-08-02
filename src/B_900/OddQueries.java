package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddQueries {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int q = Integer.parseInt(line[1]);
            line = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            int[][] queries = new int[q][3];
            for (int i = 0; i < q; i++) {
                line = br.readLine().split(" ");
                queries[i][0] = Integer.parseInt(line[0]);//l
                queries[i][1] = Integer.parseInt(line[1]);//r
                queries[i][2] = Integer.parseInt(line[2]);//k
            }
            oddQueries(arr, queries, n, q);
        }
    }

    public static void oddQueries(int[] arr, int[][] queries, int n, int q) {
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int sumTotal = prefixSum[n - 1];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0] - 1; // -1 because l starts with 1 and not 0
            int r = queries[i][1] - 1;
            int k = queries[i][2];
            int ans;
            if (l == 0) {
                ans = sumTotal - prefixSum[r] + (r - l + 1) * k;
            } else {
                ans = sumTotal - (prefixSum[r] - prefixSum[l - 1]) + (r - l + 1) * k;
            }
            if (ans % 2 != 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
