package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class DeletiveEditing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            String s = line[0];
            String target = line[1];
            deletiveEditing(s, target);
        }
    }

    public static void deletiveEditing(String s, String t) {
        // I made a position array which captures the last occurance of characters of String t in String s
        int[] pos = new int[t.length()];
        int p = t.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (p >= 0 && s.charAt(i) == t.charAt(p)) {
                pos[p] = i;
                p--;
            }
        }
        if (p >= 0) { // this means all characters of String t were not present in String s
            System.out.println("No");
            return;
        }

        HashSet<Character> hs = new HashSet<>(); // Now the logic I used is that I
        // let's say last occurance of TRME is [2,4,5,8] no words before
        // index 2 (i.e. last occurance 1st word i.e. 'T') can be easily removed so no
        // need to check for them so it means we have made character 'T' so simply add it
        // in Hashset. Now we will try to make next word i.e. R and for that to happen there
        // should be no occurance of 'T' in middle of 'T' and 'R' i.e. pos =2 an pos =4 in
        // String s because then we would have to remove the letter we already made i.e. 'T'
        // so if no occurance of 'T' then we can add 'R' now we will do same for 'M' i.e. check
        // if 'T' or 'R' exsist in between 'R' and 'M' in String s ans so on. Just dry run for DETERMINED TRME
        hs.add(t.charAt(0));
        for (int i = 1; i < pos.length; i++) {
            int j = pos[i - 1] + 1;
            while (j < s.length() && j < pos[i]) {
                if (hs.contains(s.charAt(j))) {
                    System.out.println("No");
                    return;
                }
                j++;
            }
            hs.add(t.charAt(i));
        }
        int k = pos[t.length() - 1] + 1;
        while (k < s.length()) { // Checking weather we can remove remaining elements or not
            if (hs.contains(s.charAt(k))) {
                System.out.println("No");
                return;
            }
            k++;
        }
        System.out.println("Yes");
    }
}
