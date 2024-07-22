package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneAndTwo {
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
            oneAndTwo(arr);
        }
    }

    public static void oneAndTwo(int[] arr) {
        int count2 = 0;
        for (int ele : arr) if (ele == 2) count2++;
        if (count2 % 2 != 0) {
            System.out.println(-1);
        } else {
            int currCount = 0;
            int pos = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 2) {
                    currCount++;
                }
                if (currCount - (count2 / 2) == 0) {
                    pos = i;
                    break;
                }
            }
            System.out.println(pos + 1);
        }
    }
}
