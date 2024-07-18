package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DoremysPaint3 {
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
            game(arr);
        }
    }

    public static void game(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int ele : arr) {
            if (hm.containsKey(ele)) {
                hm.put(ele, hm.get(ele) + 1);
            } else {
                hm.put(ele, 1);
            }
        }
        if (hm.size() == 1) {
            System.out.println("Yes");
            return;
        }
        if (hm.size() > 2) {
            System.out.println("No");
            return;
        }
        int prevFreq = -1;
        for (int freq : hm.values()) {
            if (prevFreq == -1) {
                prevFreq = freq;
            } else {
                if (prevFreq == freq || Math.abs(prevFreq - freq) == 1) {
                    System.out.println("Yes");
                    return;
                } else {
                    System.out.println("No");
                    return;
                }
            }
        }
    }
}
