package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ForbiddenInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int x = Integer.parseInt(line[2]);
            forbiddenInteger(n, k, x);
        }
    }

     // We can make any number if 1 is given to us but if x = 1 then we have to think
     // when x = 1 then :-
     // Number can be even or it can be odd
     // if it is even then we can make it from 2
     // if it is odd then we can make it from combination of 2 and 3 because 3 is nothing but (2+1)
    public static void forbiddenInteger(int n, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (n % 2 == 0) {
            if (x == 1) {
                if (k < 2) {
                    System.out.println("No");
                    return;
                } else { // make answer from 2
                    while (n > 0) {
                        n = n - 2;
                        ans.add(2);
                    }
                }
            } else { // x = 2 or more. So we can simply make using 1
                while (n > 0) {
                    n = n - 1;
                    ans.add(1);
                }
            }
        } else { // N is odd
            if (x == 1) {
                if (k <= 2) {
                    System.out.println("No");
                    return;
                } else { // make from 2 and 3
                    n = n - 3; // after doing this n will always be even because 3 is nothing
                    // but 2+1. You can try on any odd value
                    ans.add(3);
                    while (n > 0) {
                        n = n - 2;
                        ans.add(2);
                    }
                }
            } else { // x = 2 or more. So we can simply make using 1
                while (n > 0) {
                    n = n - 1;
                    ans.add(1);
                }
            }
        }
        System.out.println("Yes");
        System.out.println(ans.size());
        for (int ele : ans) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
