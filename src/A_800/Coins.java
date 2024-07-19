package A_800;

import java.util.*;
import java.io.*;

public class Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            long n = Long.parseLong(line[0]);
            long k = Long.parseLong(line[1]);
            coins(n, k);
        }
    }

    public static void coins(long n, long k) {
        if (k == n || k == 1) {
            System.out.println("YES");
        } else if (k > n) {
            if (n % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            if (k % n == 0) {
                System.out.println("YES");
            } else if (n % 2 == 0) {
                System.out.println("YES");
            } else if (k % 2 == 0) {
                if (n % 2 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                if (n % 2 == 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }

    }
}