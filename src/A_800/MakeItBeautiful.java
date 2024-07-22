package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MakeItBeautiful {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            makeItBeautiful(arr);
        }
    }

    // 1st 2 elements should be min and max respectively because
    // then all remaining elements will be less than sum of these 2
    // and obviously if min == max then answer does not exist
    public static void makeItBeautiful(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (min == max) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            ArrayList<Integer> al = new ArrayList<>();
            al.add(min);
            al.add(max);
            boolean minFound = false;
            boolean maxFound = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == min && !minFound) {
                    minFound = true;
                    continue;
                }
                if (arr[i] == max && !maxFound) {
                    maxFound = true;
                    continue;
                }
                al.add(arr[i]);
            }
            for (int ele : al) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
