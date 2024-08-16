import java.util.*;

public class Dummy {
    public static void main(String args[]) {

    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            max = Math.max(max, Math.max(curr, prev + curr));
            prev = Math.max(curr, prev + curr);
        }
        return max;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProd = new int[n];

        prefixProd[0] = nums[0];
        for (int i = 1; i < n; i++) prefixProd[i] = nums[i] * prefixProd[i - 1];

        int[] suffixProd = new int[n];

        suffixProd[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) suffixProd[i] = nums[i] * suffixProd[i + 1];

        int[] ans = new int[n];
        ans[0] = suffixProd[1];
        ans[n - 1] = prefixProd[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = prefixProd[i - 1] * suffixProd[i + 1];
        }

        return ans;
    }


}