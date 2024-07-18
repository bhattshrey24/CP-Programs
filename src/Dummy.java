import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Dummy {
    public static void main(String args[]) {
        // System.out.println("Shre".substring(1, 4))
        //dummy1();
        System.out.println("Shrey".substring(2));
    }

    //    public boolean wordBreak(String s, List<String> wordDict) {
//        int n = s.length();
//        boolean[] dp = new boolean[n + 1];
//        dp[0] = true;
//        int max_len = 0;
//        for (String word : wordDict) {
//            max_len = Math.max(max_len, word.length());
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
//                if (dp[j] && wordDict.contains(s.substring(j, i))) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//
//        return dp[n];
//    }
    public static void dummy1() {
        List<Integer> res = new ArrayList<>();
        dummy2(res);
        for (int ele : res) {
            System.out.println(ele);
        }
    }

    public static void dummy2(List<Integer> res2) {
        res2.add(10);
        res2.add(20);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); // A LIST IS ALSO PASSED BY
        // REFERENCE JUST LIKE AN ARRAY. Observe below
        makeCombination(0, 0, target, new ArrayList<>(), res, candidates);
        return res;
    }

    private void makeCombination(int i, int total, int target, List<Integer> currComb, List<List<Integer>> ans, int[] candidates) {
        if (total == target) {
            ans.add(new ArrayList<>(currComb));
            return;
        }

        if (total > target || i >= candidates.length) {
            return;
        }

        currComb.add(candidates[i]);
        makeCombination(i, total + candidates[i], target, currComb, ans, candidates); // This is unbounded knapsack
        currComb.remove(currComb.size() - 1); // removing last element from current
        // combination so that we can try all combinations
        makeCombination(i + 1, total, target, currComb, ans, candidates);
    }


//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        return combinationSum(0, target, new ArrayList<>(), candidates);
//    }
//    public List<List<Integer>> combinationSum(int i, int target, List<Integer> currAns, int[] candidates) {
//        if (i == candidates.length) {
//            if (target == 0) {
//                List<List<Integer>> ans = new ArrayList<>();
//                ans.add(currAns);
//                System.out.print("i "+i+ " i=N ");
//                for (int ele : currAns) {
//                    System.out.print(ele + " ");
//                }
//                System.out.println();
//                return ans;
//            } else {
//                return null;
//            }
//        }
//        if (target < 0) {
//            return null;
//        }
//
//        if ((target - candidates[i]) == 0) {
//            List<List<Integer>> ans = new ArrayList<>();
//            ans.add(currAns);
//            System.out.print("i "+i+ " t=0 ");
//            for (int ele : currAns) {
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//            return ans;
//        }
//
//        if (target - candidates[i] > 0) {
//            System.out.print("i "+i +" B :  ");
//            for (int ele : currAns) {
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//            List<List<Integer>> without = combinationSum(i + 1, target, currAns, candidates);
//            currAns.add(candidates[i]);
//            List<List<Integer>> with = combinationSum(i, target - candidates[i], currAns, candidates);
//            currAns.remove(currAns.size()-1);
//            System.out.print("i "+i + " A :  ");
//            for (int ele : currAns) {
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//            List<List<Integer>> ans = new ArrayList<>();
//            if (with != null) {
//                ans.addAll(with);
//            }
//            if (without != null) {
//                ans.addAll(without);
//            }
//            return ans;
//        } else {
//            return combinationSum(i + 1, target, currAns, candidates);
//        }
//    }


    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        HashSet<String> dict = new HashSet<String>(wordDict);
        int ans = mcm(0, n - 1, s, dict, dp);
        return ans == 1;
    }

    public static int mcm(int i, int j, String str, HashSet<String> dict, int[][] dp) {
        if (i > j) {// base case 1
            return 0;
        }
        if (i == j) {// base case 2
            if (dict.contains(str.substring(i, j + 1))) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[i][j] != -1) return dp[i][j];

        if (dict.contains(str.substring(i, j + 1))) {// base case 3
            return 1;
        }

        int flag = 0;
        for (int k = i; k < j; k++) {
            int leftCall = mcm(i, k, str, dict, dp);
            int RightCall = mcm(k + 1, j, str, dict, dp);
            boolean currAns = leftCall == 1 && RightCall == 1;
            if (currAns) {
                flag = 1;
                break;
            }
        }
        dp[i][j] = flag;
        return dp[i][j];
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // Sorting so that we can check if previous and current element are same or not i.e. duplicates or not
        combinationSum2Rec(0, 0, target, candidates, new ArrayList<Integer>(), ans, false);
        return ans;
    }

    // We are simply using Subset 2 solution and just doing small modifications in it.
    public void combinationSum2Rec(int i, int currTotal, int target, int[] nums, List<Integer> currComb, List<List<Integer>> ans, boolean isPrevSelected) {
        if (i == nums.length) { // Base Case 1 : i.e. if we reached end
            if (currTotal == target) {
                ans.add(new ArrayList<>(currComb));
                return;
            } else {
                return;
            }
        }
        if (currTotal == target) { // Base case 2 : This is an optional base case i.e. I have
            // added this to improve TC because if while traveling a branch we exceeded
            // target then no need to go further
            ans.add(new ArrayList<>(currComb));
            return;
        }
        if (currTotal > target) {
            return;
        }

        if (i >= 1 && nums[i] == nums[i - 1] && !isPrevSelected) { // By doing dry run, we observerd this pattern
            combinationSum2Rec(i + 1, currTotal, target, nums, currComb, ans, false); // only calling recursion for 'not select current element'
        } else { // calling for both select and not select
            currComb.add(nums[i]);
            combinationSum2Rec(i + 1, currTotal + nums[i], target, nums, currComb, ans, true); // select current element
            currComb.remove(currComb.size() - 1);
            combinationSum2Rec(i + 1, currTotal, target, nums, currComb, ans, false); // not select current element
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionRec(s, 0, s.length(), new ArrayList<String>(), ans);
        return ans;
    }

    public void partitionRec(String str, int used, int len, ArrayList<String> currAns, List<List<String>> res) {
        if (used == len) {
            res.add(new ArrayList<>(currAns));
            return;
        }
        for (int i = 1; i <= str.length(); i++) {
            if (isPalindrome(str.substring(0, i))) {
                currAns.add(str.substring(0, i));
                partitionRec(str.substring(i), used + i, len, currAns, res);
                currAns.remove(currAns.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        boolean flag = true;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return flag;
    }
}
