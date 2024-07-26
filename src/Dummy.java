import java.util.*;

public class Dummy {
    public static void main(String args[]) {
        System.out.println();

    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 0; // Base case i.e. if we are at
        // destination then min jumps required is 0
        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            int maxJump = nums[i];
            for (int j = 1; j <= maxJump; j++) { // Here we check all the jumps because any jump
                // can result in answer unlike in method 3 of jump game 1 question where
                // we just had to find weather we can reach end or not. Here we have to find
                // optimal result i.e. minimum jumps therefore DP is needed
                if ((i + j) < n && dp[i + j] != Integer.MAX_VALUE) { // If an index has Infinity stored then it
                    // means we cannot reach destination from that index
                    min = Math.min(min, 1 + dp[i + j]);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }

//    public int jump(int[] nums) {
//        return jumpRec(0, nums);
//    }

    public int jumpRec(int curr, int[] nums) {
        if (curr >= nums.length) return Integer.MAX_VALUE;
        if (curr == nums.length - 1) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[curr]; i++) {
            if(jumpRec(curr + i, nums)!=Integer.MAX_VALUE){
                min = Math.min(min,1 + jumpRec(curr + i, nums));
            }
        }
        return min;
    }


}
