package A_800;

import java.util.*;
import java.io.*;

public class UnitArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            unitArray(arr);
        }
    }

    public static void unitArray(int[] arr) {
        int cn = 0;
        int cp = 0;
        for (int ele : arr) {
            if (ele == 1) {
                cp++;
            } else {
                cn++;
            }
        }
        if (cn <= cp) {
            if (cn % 2 == 0) {
                System.out.println("0");
            } else {
                System.out.println("1");
            }
        } else {
            int gap = cn - cp;
            int x = (int) Math.ceil((gap * 1.0) / 2);
            cn = cn - x;
            if (cn % 2 == 0) {
                System.out.println(x);
            } else {
                System.out.println((x + 1));
            }
        }
    }
}
