package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeItZero {
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
            makeItZero(arr, n);
        }
    }

    public static void makeItZero(int[] arr, int n) {
        // Using the property that a xor a xor a xor a = 0 , a xor 0 = a
        if (n % 2 == 0) {
            System.out.println(2);
            System.out.println(1 + " " + n);
            System.out.println(1 + " " + n);
        } else {
            System.out.println(4);
            System.out.println(1 + " " + n);
            System.out.println(2 + " " + n);
            System.out.println(1 + " " + 2);
            System.out.println(1 + " " + 2);
        }
    }
}