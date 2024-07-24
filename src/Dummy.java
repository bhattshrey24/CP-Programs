import java.util.*;

public class Dummy {
    public static void main(String args[]) {
        System.out.println();

    }

    // There is a faster way. See solutions

    // Using 1D dp
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n]; // Observe here since we have to reach till last
        // index and not beyond last index therefore dp size is not n+1
        dp[n - 1] = true; // Jump at last index are of no use because
        // we have to reach till last index only and not beyond
        for (int i = n - 2; i >= 0; i--) { // Also here we move from last
            // to 1st. If you have an algo which you think can work from left to
            // right (like the recursive approach we used) then just Dry Run that for [2,2,1,0] and [1,1,0,2]
            int maxJumps = nums[i];
            System.out.println(maxJumps);
            boolean flag = false;
            for (int j = 1; j <= maxJumps; j++) {
                if ((i + j) >= 0 && dp[i + j]) {
                    flag = true;
                    break;
                }
            }
            dp[i] = flag;
        }
        for (boolean ele : dp) {
            System.out.println(ele);
        }
        return dp[0];
    }

//    public boolean canJumpRec(int curr, int[] nums) {
//        if (curr >= nums.length) return false;
//        if (curr == nums.length - 1) return true;
//        boolean flag = false;
//        for (int i = 1; i <= nums[curr]; i++) {
//            if (canJumpRec(curr + i, nums)) {
//                flag = true;
//                break;
//            }
//        }
//        return flag;
//    }

//    public boolean canJump(int[] nums) {
//        return canJumpRec(0, nums);
//    }
//
//    public int canJumpRec(int curr, int[] nums) {
//        if (curr >= nums.length) return 0;
//        if (curr == nums.length - 1) return 1;
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i <= nums[curr]; i++) {
//           min = Math.min(min,canJumpRec(curr + i, nums));
//        }
//        return min;
//    }
}
