package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrependAndAppend {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) { // t-- will first use the value of t and then decrease it
            // Taking input
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            String s = br.readLine();
            // Running solution
            prependAndAppend(s, n);
        }
    }

    public static void prependAndAppend(String s, int n) {
        int minCount = n;
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                break;
            }
            i++;
            j--;
            minCount -= 2;
        }
        System.out.println(minCount);
    }
}
