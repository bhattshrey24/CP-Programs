package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComparisonString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int[] arr = new int[n];
            comparisonString(str, n);
        }
    }

    public static void comparisonString(String str, int n) {
        int maxGreaterCount = 0;
        int maxSmallerCount = 0;
        int currGreaterCount = 0;
        int currSmallerCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                currGreaterCount++;
                currSmallerCount = 0;
            } else {
                currSmallerCount++;
                currGreaterCount = 0;
            }
            maxGreaterCount = Math.max(maxGreaterCount, currGreaterCount);
            maxSmallerCount = Math.max(maxSmallerCount, currSmallerCount);
        }
        int ans = Math.max(maxGreaterCount, maxSmallerCount) + 1;
        System.out.println(ans);
    }
}
