package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowMuchDoesDaytonaCost {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            //int[] arr = new int[n];
            line = br.readLine().split(" ");
            boolean isFound = false;
            for (int i = 0; i < n; i++) {
                int ele = Integer.parseInt(line[i]);
                if (ele == k) {
                    System.out.println("Yes");
                    isFound = true;
                    break;
                }
            }
            if(isFound){
                continue;
            }
            System.out.println("No");
        }
    }

}
