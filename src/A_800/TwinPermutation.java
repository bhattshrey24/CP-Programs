package A_800;

import java.util.*;
import java.io.*;

public class TwinPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            System.out.println();
            TwinPermutations(arr);
        }
    }

    public static void TwinPermutations(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) { // making 'ai+bi' same for every
            // element. Just do dry run and see 'ai+bi' for every i
            int ele = n - a[i] + 1;
            System.out.print(ele + " ");
        }
    }
}