package A_800;

import java.util.*;
import java.io.*;

public class BlankSpace {
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
            blankSpace(arr);
        }
    }

    public static void blankSpace(int[] arr) {
        int max = 0;
        int currCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                currCount++;
            } else {
                max = Math.max(max, currCount);
                currCount = 0;
            }
        }
        max = Math.max(max, currCount); // checking for last blank space
        System.out.println(max);
    }
}
