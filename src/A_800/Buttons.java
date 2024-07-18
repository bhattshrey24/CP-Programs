package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Buttons {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            buttons(a, b, c);
        }
    }

    public static void buttons(int a, int b, int c) {
        if (a == b) {
            if (c % 2 != 0) {
                System.out.println("First");
            } else {
                System.out.println("Second");
            }
        } else if (a > b) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }
    }

}
