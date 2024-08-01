package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class PermutationSwap {
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
            permutationSwap(arr, n);
        }
    }

    // The logic is simple. We will find how far is every element from
    // it's correct position (ignore if element is at it's right position)
    // Now the difference i.e. between actual and correct position can be many like
    // some can  have difference of 2 some can have difference of 6 etc
    // So answer in above case is 2 because we can make 6 swap by using 2 swap i.e. 2+2+2
    // but we cannot make 2 swaps using 6 swaps (remember we cannot think of array as circular)
    // So if all the differences are not divisible by minimum difference then the answer will be all
    // of their GCD i.e. for perm = [5,8,3,4,1,6,7,2] the answer is 2 as the GCD (4,6) is 2
    public static void permutationSwap(int[] perm, int n) {
        int min = Integer.MAX_VALUE;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(perm[i] - (i + 1));
            if (diff != 0) {
                min = Math.min(diff, min);
                hs.add(diff);
            }
        }
        int gcd = 0;
        int prev = -1;
        int curr;
        boolean isAllMultiple = true;
        for (int ele : hs) {
            if (ele % min != 0) isAllMultiple = false;
            if (prev == -1) {
                prev = ele;
                continue;
            }
            curr = ele;
            gcd = gcd(prev, curr);
            prev = gcd;
        }
        if(isAllMultiple){
            System.out.println(min);
        }else{
            System.out.println(gcd);
        }
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

}
