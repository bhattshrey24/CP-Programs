package A_800;// https://codeforces.com/problemset/problem/1901/A

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineTrip {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) { // t-- will first use the value of t and then decrease it
            // Taking input
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);

            line = br.readLine().split(" ");
            int[] arr = new int[n + 1]; // this +1 is for last one
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            // Running solution
            minFuel(arr, x);

        }
    }

    public static void minFuel(int[] arr, int x) { // bus minimum distance nikalna hai and we
        // have to keep in mind ki wapis bhi aana hai and 'x' pr koi fuel tank nhi hai so last station pe inta
        // fuel hona chahiye ki wanha se x tk and x se wapis last fuel tk aa ske
        int n = arr.length - 1;
        arr[n] = arr[n - 1] + ((x - arr[n - 1]) * 2);
        int minFuel = Integer.MIN_VALUE;
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            minFuel = Math.max(minFuel, arr[i] - prev);
            prev = arr[i];
        }
        System.out.println(minFuel);
    }


}
