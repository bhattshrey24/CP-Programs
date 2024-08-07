package B_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AvtoBus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            avtoBus(n);
        }
    }

    public static void avtoBus(long n) {
        if (n % 2 != 0) { // n = odd
            System.out.println(-1);
        } else { // n = even
            long min, max;
            long temp = n;
            long count;
            if (n % 4 == 0 && n % 6 == 0) {
                max = n / 4;
                min = n / 6;
            } else if (n % 4 == 0) {
                max = n / 4;
                temp = temp - 4;
                count = 1;
                while (temp > 0 && temp % 6 != 0) { // the concept here is since we are
                    // finding minimum so the closest multiple of 6 here would be the answer, so we
                    // will keep removing 4 till we get a number which is a multiple of 6
                    temp = temp - 4;
                    count++;
                }
                if (temp <= 0) {
                    min = max;
                } else {
                    min = count + (temp / 6);
                }
            } else if (n % 6 == 0) {
                min = n / 6;
                temp = temp - 6;
                count = 1;
                while (temp > 0 && temp % 4 != 0) {
                    temp = temp - 6;
                    count++;
                }
                if (temp <= 0) {
                    max = min;
                } else {
                    max = count + (temp / 4);
                }
            } else { // when n is even but not divisible by 6 or 4 like 26 , 22 etc
                temp = temp - 4;
                count = 1;
                while (temp > 0 && temp % 6 != 0) {
                    temp = temp - 4;
                    count++;
                }
                min = count + (temp / 6);
                if (temp <= 0) {
                    System.out.println(-1);
                    return;
                }
                temp = n;
                temp = temp - 6;
                count = 1;
                while (temp > 0 && temp % 4 != 0) { // this warning on intellij is wrong
                    temp = temp - 6;
                    count++;
                }
                if (temp <= 0) {
                    System.out.println(-1);
                    return;
                }
                max = count + (temp / 4);
            }
            System.out.println(min + " " + max);
        }
    }
}
