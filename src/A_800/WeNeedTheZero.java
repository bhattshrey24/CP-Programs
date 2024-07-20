package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeNeedTheZero {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            weNeedTheZeros(arr);
        }
    }

    // Must watch https://www.youtube.com/watch?v=J2PEI3iw0Dw
    // We are using associative and commutative property of xor i.e.
    // b1^b2 = (a1^x)^(a2^x) = a1^x^a2^x = a1^x^x^a2 = a1^0^a2 = a1^a2
    public static void weNeedTheZeros(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        if (arr.length % 2 == 0) {
            if (ans == 0) {
                System.out.println(ans); // you can return any non negative integer here
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(ans);
        }
    }
}
