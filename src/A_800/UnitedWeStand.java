package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UnitedWeStand {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(line[i]);
            }
            System.out.println();
            unitedWeStand(a);
        }
    }

    public static void unitedWeStand(int[] a) { // its a simple observation based question and we
        // just have to take care that bi/cj!=0 (it is possible that cj/bi == 0) . So we simply
        // keep smallest element in 'b' and rest in 'c' because we know bigger number
        // cannot divide smaller number like 12 cannot divide 3
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        for (int ele : a) {
            min = Math.min(ele, min);
        }

        for (int ele : a) {
            if (ele == min) {
                b.add(ele);
            } else {
                c.add(ele);
            }
        }
        if (b.size() == 0 || c.size() == 0) {
            System.out.print(-1);
        } else {
            System.out.println(b.size() + " " + c.size());
            for (int ele : b) {
                System.out.print(ele + " ");
            }
            System.out.println();
            for (int ele : c) {
                System.out.print(ele + " ");
            }
        }
    }

}
