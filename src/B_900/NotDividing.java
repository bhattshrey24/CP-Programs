package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotDividing {
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
            notDividing(arr, n);
        }
    }

    public static void notDividing(int[] arr, int n) {
        // 1 is critical because 1 can divide any number so our
        // algo will try to manage whenever we encounter 1. So there are simply 4 cases i.e.
        // c1  : prev !=1 && curr!=1
        // c2  : prev ==1 && curr==1
        // c3  : prev !=1 && curr==1
        // c4  : prev ==1 && curr!=1
        int[] newArr = new int[n];
        int prev = arr[0];
        int curr;
        newArr[0] = prev;
        for (int i = 1; i < arr.length; i++) {
            curr = arr[i];
            if (prev != 1 && curr != 1) {
                if (curr % prev == 0) {
                    curr++;
                }
                newArr[i] = curr;
                prev = curr;
            } else if (prev == 1 && curr == 1) {
                newArr[i - 1]++;
                curr += 2;
                newArr[i] = curr;
                prev = curr;
            } else if (curr == 1) {
                curr++;
                if (curr % prev == 0) {
                    curr++;
                }
                newArr[i] = curr;
                prev = curr;
            } else {
                prev = newArr[i - 1] + 1;
                newArr[i - 1] = prev;
                if (curr % prev == 0) {
                    curr++;
                }
                newArr[i] = curr;
                prev = curr;
            }
        }
        for (int ele : newArr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
