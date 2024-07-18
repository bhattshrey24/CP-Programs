package ReadMe;
// If you are submitting the file then the name of the class and the file should be same
// Don't use scanner to take input instead use BufferedReader as it is less
// prone to error like codeforces might sometimes have extra
// newlines between test cases and Scanner is not good with such extra spaces
// therefore use buffered reader

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Below is a basic layout that you can use
public class Solutions {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) { // t-- will first use the value of t and then decrease it
            // Taking input
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            line = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }

            // Running solution
            minBoxes(arr, k);

        }
    }

    public static void minBoxes(int[] arr, int k) {
        // Your Code
    }

}
