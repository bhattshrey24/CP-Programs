package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EverybodyLikesGoodArrays {
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
            everybodyLikesGoodArrays(arr);
        }
    }

    // Parity means odd and even
    // they said 'find minimum' to fool you . There exists just one answer and it will be minimum.
    // I am just traversing the array and simply trying to make it good
    public static void everybodyLikesGoodArrays(int[] arr) {
        int min = 0;
        boolean isPrevEven = arr[0] % 2 == 0;
        for (int i = 1; i < arr.length; i++) {
            boolean isCurrEven = arr[i] % 2 == 0;
            if ((isPrevEven && isCurrEven) || (!isPrevEven && !isCurrEven)) {
                min++;
            } else {
                isPrevEven = isCurrEven;
            }
        }
        System.out.println(min);
    }
}
