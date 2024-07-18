package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GrasshopperOnALine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            System.out.println();
            grasshopperOnALine(n, k);
        }
    }

    public static void grasshopperOnALine(int n, int k) {
        if (n % k != 0 || n < k) {
            System.out.println(1);
            System.out.println(n);
        } else {
            System.out.println(2);
            System.out.print((n - 1) + " " + 1);
        }
    }
}
