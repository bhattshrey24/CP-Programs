package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Chemistry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            String s = br.readLine();
            chemistry(s, n, k);
        }
    }

    public static void chemistry(String s, int n, int k) {
        HashMap<Character, Integer> freqHm = buildHm(s);
        for (Map.Entry<Character, Integer> mapEntry : freqHm.entrySet()) {
            if (mapEntry.getValue() % 2 != 0 && k > 0) {
                k--;
                mapEntry.setValue(mapEntry.getValue() - 1); //Note:  using 'mapEntry.setValue' we can
                // update hashmap while traversing
                if (k == 0) {
                    break;
                }
            }
        }
        int count = 0;
        for (int value : freqHm.values()) {
            if (value % 2 != 0) {
                count++;
            }
        }
        if (count > 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    public static HashMap<Character, Integer> buildHm(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {
                hm.put(ch, 1);
            }
        }
        return hm;
    }

}
