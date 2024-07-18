package A_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoalsOfVictory {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] eff = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                eff[i] = Integer.parseInt(line[i]);
            }
            game(eff);
        }
    }
    // Dry run for 5 teams and give random efficiency to first 4 teams and you'll see the pattern
// combinations of 4 teams are
// t1 t2
// t1 t3
// t1 t4
// t2 t3
// t2 t4
// t3 t4
// We are doing greedy approach by assigning efficiency - 0 in the 1st
// combination and rest 0-0 then again for 2nd team we are doing same like see :-
// eff = [3,-4, 5] so then
// t1 t2 = 3-0 // now t2 has lost by 3 goals so we keep track of that too
// t1 t3 = 0-0
// t1 t4 = 0-0
// t2 t3 = 0-1 // t2 needs to lose by 1 because t2 has already lost by 3 goals so we just need to make it lose another game by 1 goal
// t2 t4 = 0-0
// t3 t4 = 4-0
    public static void game(int eff[]) {
        int[] pp = new int[eff.length + 1]; // ans of last team is at last index of pp
        for (int i = 0; i < eff.length; i++) {
            int j = i + 1;
            int x = eff[i] - pp[i];
            pp[i] += x;
            pp[j] += (-x); // same as pp[j]-=x , I have written
            // like this just for understanding the concept
        }
        System.out.println(pp[eff.length]);
    }
}
