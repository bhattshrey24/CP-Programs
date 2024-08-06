package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NITDestroysTheUniverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            nITDestroysTheUniverse(arr, n);
        }
    }

    // if there is no consecutive sequence of number without 0 then answer is 0
    // if there is exactly 1 consecutive sequence of numbers without 0 then answer is 1
    // else answer is 2. Answer cannot be more than 2 like see for [0 2 3 0 1 2 0] just take
    // l = 1 and r = n and then array will become [4 4 4 4 4 4 4] now again take l = 1  and r = n
    // so not it will become [0 0 0 0 0 0 0]
    public static void nITDestroysTheUniverse(int[] arr, int n) {
        int i = 0;
        boolean foundAtleast1Sequence = false;

        while (i < n && arr[i] == 0) {
            i++;
        }
        while (i < n && arr[i] != 0) {
            foundAtleast1Sequence = true;
            i++;
        }
        while (i < n && arr[i] == 0) {
            i++;
        }

        if (!foundAtleast1Sequence) {
            System.out.println(0);
        } else {
            if (i == n) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }

    }

}
