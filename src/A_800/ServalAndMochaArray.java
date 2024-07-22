package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServalAndMochaArray {
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
            servalAndMochaArray(b);
        }
    }

    // The question states that :-
    // we can rearrange the array ,So we have
    // to find whether it is possible to rearrange the array such that all
    // prefixes (i.e. (0th ele,1st ele) , (0,1,2) and so on) of that rearranged
    // array are good.
    // Now the condition for a prefix to be good is that
    // the (number of elements in that prefix) >= (gcd of those elements) eg :-
    // arr[1,2,4,5,6,7] so here for prefix (1,2,4,5) the gcd of (1,2,4,5) <= 4 then
    // it's considered good
    // Solution :-
    // Note : GCD of 4 elements is :-
     // Let's say elements are a,b,c and d so
     // x = gcd(a,b)
     // y = gcd(x,c)
     // z = gcd(y,d) and z is the answer for gcd (a,b,c,d) this works because gcd (a,b,c,d) is nothing
    // but if you do prime factorization of these numbers and take out the common factors which
    // are present in prime factorization of all elements then that is your gcd eg. gcd (24,12,18) : -
     // 12 = 2*2*3
     // 24 = 2*2*2*3
     // 18 = 2*3*3
    // so gcd = 2*3 = 6. Now if you do gcd(12,24) you will get 2*2*3 i.e. 12 now these are common factors of 12 and
    // 24 so simply find gcd of this with 18
    // Now the logic I used that we have to find a pair whoe's GCD is
    // less that or equal to 2 because then we can put that pair in front
    // of array and then all the prefixes of remaining elements in that array
    // would be good too because their GCD won't go above 2
    public static void servalAndMochaArray(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (gcd(arr[i], arr[j]) <= 2) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}

