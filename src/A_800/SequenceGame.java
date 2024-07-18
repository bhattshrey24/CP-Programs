package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SequenceGame {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(line[i]);
            }
            sequenceGame(b);
        }
    }

    public static void sequenceGame(int[] b) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(b[0]);
        for (int i = 1; i < b.length; i++) {
            if (b[i] >= b[i - 1]) {
                al.add(b[i]);
            } else {
                al.add(b[i]);
                al.add(b[i]);
            }
        }
        System.out.println(al.size());
        for (int ele : al) {
            System.out.print(ele + " ");
        }
    }
}
