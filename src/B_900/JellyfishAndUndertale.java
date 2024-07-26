package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JellyfishAndUndertale {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int n = Integer.parseInt(line[2]);
            line = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            jellyfishAndUndertale(a, b, n, arr);
        }
    }

    public static void jellyfishAndUndertale(int a, int b, int n, int[] tools) {
        long ans = 0;
        int curr = b;
        if (b > a) {
            ans += b - a;
            curr = a;
        }
        for (int tool : tools) {
            if (curr > tool) { // consume if you can
                ans += tool;
            } else { // go till end and then consume
                ans += curr - 1;
                curr = Math.min(1 + tool, a);
            }
        }
        ans += curr; // now all tools are finished so consume remaining seconds
        System.out.println(ans);
    }

}
