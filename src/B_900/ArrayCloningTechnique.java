package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ArrayCloningTechnique {
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
            arrayCloningTechnique(arr, n);
        }
    }

    public static void arrayCloningTechnique(int[] arr, int n) {
        long maxFreq = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int ele : arr) {
            if (freq.containsKey(ele)) {
                int newFreq = freq.get(ele) + 1;
                freq.put(ele, newFreq);
                maxFreq = Math.max(newFreq, maxFreq);
            } else {
                freq.put(ele, 1);
                maxFreq = Math.max(1, maxFreq);
            }
        }
        if (maxFreq == n) {
            System.out.println(0);
            return;
        }
        int copy = 0;
        long swap = 0;
        long rem = n - maxFreq;
        while (rem > 0) {
            copy++;
            if (rem <= maxFreq) {
                swap = swap + rem;
                break;
            }
            swap = swap + maxFreq;
            rem = rem - maxFreq;
            maxFreq = maxFreq * 2;
        }
        System.out.println(copy + swap);
    }
}
