package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DontTryToCount {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[0]);
            String x = br.readLine();
            String s = br.readLine();
           // System.out.println(x+" "+s);
            dontTryToCount(x, s);
        }
    }

    public static void dontTryToCount(String x, String s) {
        int count = 0;
        StringBuilder xB = new StringBuilder(x);
        while (xB.length() < s.length()) {
            xB.append(xB);
            count++;
        }
        x = xB.toString();
        int n = x.length();
        int m = s.length();
        boolean isFound = false;
        for (int i = 0; i <= (n - m); i++) {
            int j = 0;
            while (j < m) {
                if (s.charAt(j) != x.charAt(i + j)) {
                    break;
                }
                j++;
            }
            if (j == m) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println(count);
            return;
        }

        xB.append(xB);
        count++;
        x = xB.toString();
        n = x.length();
        for (int i = 0; i <= (n - m); i++) {
            int j = 0;
            while (j < m) {
                if (s.charAt(j) != x.charAt(i + j)) {
                    break;
                }
                j++;
            }
            if (j == m) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
