package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoverInWater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) { // t-- will first use the value of t and then decrease it
            // Taking input
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);

            line = br.readLine().split("");
            String[] containers = new String[n];
            for (int i = 0; i < n; i++) {
                containers[i] = line[i];
            }
            minWater(containers, n);
        }
    }

    public static void minWater(String[] containers, int n) { // It's quite simple , if gap
        // between 2 blocks if more than or equal to 3 then we have found an infinite
        // water source and hence we can fill all empty spaces using it else we have to
        // count all the gaps between 2 blocks because then we simply have to
        // put water in every one of them
        int max = Integer.MIN_VALUE;
        int gap = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (containers[i].equals(".")) {
                gap++;
            } else {
                ans += gap;
                max = Math.max(max, gap);
                gap = 0;
            }
        }
        ans += gap;
        max = Math.max(max, gap);
        if (max >= 3) {
            System.out.println(2);
        } else {
            System.out.println(ans);
        }
    }
}
