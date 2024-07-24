package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VasilijeInCacak {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            long n = Integer.parseInt(line[0]);
            long k = Integer.parseInt(line[1]);
            long x = Long.parseLong(line[2]);
            vasilijeInCacak(n, k, x);
        }
    }

    // The logic I used is simple basically if the x that we want to make lies between
    // a and b where 'a' is min sum we can make with k number of elements and 'b' is max sum
    // we can make with k number of element then it is true eg : -
    // for : 9 3 40 so N = 9 i.e 1,2,3,4,5,6,7,8,9 so here min sum we
    // can make from 3 elements is 1+2+3 = 6 and max sum is 7+8+9 = 24 now x
    // does not lie in this range therefore answer is no this works because we have all the number
    // from 1 onwards so we can make any number if it lies in the range of window. You can dry run for a
    // small n and see if it is true or not
    public static void vasilijeInCacak(long n, long k, long x) {
        long sumMin = k * (1 + k) / 2; // using sum of AP formula n/2 * (a+an)
        long sumMax = k * ((n - k + 1) + n) / 2;
        if (sumMin <= x && x <= sumMax) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
