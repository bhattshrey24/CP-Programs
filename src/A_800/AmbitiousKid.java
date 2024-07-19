package A_800;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class AmbitiousKid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        ambitiousKid(arr);
    }

    public static void ambitiousKid(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int ele : arr) {
            min = Math.min(min, Math.abs(ele));
        }
        System.out.println(min);
    }
}