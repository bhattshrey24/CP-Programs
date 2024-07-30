import java.util.*;

public class Dummy {
    public static void main(String args[]) {
//        System.out.println(checkForPrime(4));
//        System.out.println(checkForPrime(5));
//        System.out.println(checkForPrime(3));
//        System.out.println(checkForPrime(12));
//        int ceil = (int) Math.ceil(Math.sqrt(10));
//        System.out.println(ceil);
//        int ceil1 = (int) Math.ceil(Math.sqrt(9));
//        System.out.println(ceil1);
//        int ceil2 = (int) Math.ceil(Math.sqrt(8));
//        System.out.println(ceil2);
        // nonSpecialCount(5, 7);
        dummy("1001101");
        dummy("0110110");
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null; // Handling edge case i.e. when graph is empty

        Queue<Node> que = new ArrayDeque<>();
        HashMap<Node, Node> vis = new HashMap<>();

        vis.put(node, new Node(node.val)); // Add the initial node and its copy to the map
        que.add(node);

        while (!que.isEmpty()) {
            Node rem = que.remove();
            Node nodeCopy = vis.get(rem);

            for (Node neighbor : rem.neighbors) {
                if (!vis.containsKey(neighbor)) { // Just think about connecting current
                    // element with it's neighbor for each call
                    Node neighborCopy = new Node(neighbor.val);
                    vis.put(neighbor, neighborCopy);
                    que.add(neighbor);
                }
                nodeCopy.neighbors.add(vis.get(neighbor)); // Connecting current element with it's neighbor
            }
        }
        return vis.get(node);
    }


    //    public Node cloneGraph(Node node) {
//        if (node == null) return null; // Handling edge case i.e. when graph is empty
//        return dfs(node, new HashMap<>());
//    }
//
//    public Node dfs(Node node, HashMap<Node, Node> vis) {
//        if (vis.containsKey(node)) {
//            return vis.get(node); // Observe here we return new node because we
//            // don't want to create the same node again
//        }
//
//        Node nodeCopy = new Node(node.val); // Work
//        vis.put(node, nodeCopy); // Mark
//
//        for (Node children : node.neighbors) { // Add : Observe here we are not checking
//            // if(!vis.containsKey(node)) instead we are running the loop for all edges irrespective of
//            // weather they are visited or not because if it is visited then the
//            // base case will return the new node and we can just connect to it and if it is
//            // not present then dfs will create the new node and connect remaining graph and return the new
//            // node to us so that we can connect with it
//            Node neighborCopy = dfs(children, vis);
//            nodeCopy.neighbors.add(neighborCopy);
//        }
//        return nodeCopy;
//    }
    public static void dummy(String s) {
        int[] prefixCount1 = new int[s.length()];
        prefixCount1[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            prefixCount1[i] = prefixCount1[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.print(prefixCount1[i] + " | ");
        }
        System.out.println();
    }

    // This is a tricky question because the test cases are hard to pass. It does not accept N^2 solution.

    // The logic here is that we will traverse through all possible substrings and we will try to skip some substrings
    // based on some conditions.
    public int numberOfSubstrings(String s) {
        int[] prefixCount1 = new int[s.length()];

        prefixCount1[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) { // simply creating prefix sum. This will help us
            // to get count of 1 in a range (i,j)
            prefixCount1[i] = prefixCount1[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int count1 = i != 0 ? (prefixCount1[j] - prefixCount1[i - 1]) : prefixCount1[j];
                int count0 = (j - i + 1) - count1; // number of 0's is simply number of elements in
                // current window - number of 1's
                if (count0 * count0 <= count1) {
                    ans += 1;
                    int sqrtOf1s = (int) Math.sqrt(count1);
                    if (sqrtOf1s > count0) { // This condition will be true like try to dry run for [1000111111111111111111111111111] so
                        // in this case when you reach a position where "count0 * count0 = count1"
                        // then the code will reach here in else branch and we add 1 to ans but this if statement will not be executed so
                        // loop will move on and then in next iteration again we will come in this else branch and now
                        // count of 1 is 10 and it will not go inside this if again until count of 1 is 16 because then sqrt(16) = 4>3.
                        ans = ans + ((j + (sqrtOf1s - count0)) >= s.length() ? (s.length() - j - 1) : (sqrtOf1s - count0)); //condition checks
                        // if the jump exceeds the length of string then simply add all the substrings till end otherwise add the
                        // substrings till the jump only

                        j = j + (sqrtOf1s - count0); // Jump to a position where even if we get all zeros in this jump
                        // still all those substrings are valid answers because we have enough 1's now to
                        // accommodate all these zeros that we got in the jump. eg : [1000111111111111...11] let's say we have 144
                        // ones now and only 3 zeros so now even if next 8 positions are 0 still we can add them to
                        // substring because count0*count0<count so we will simply jump 8 positions. This is not a
                        // very great optimization but the test cases are designed such that this is needed to not
                        // get TLE error
                    }

                } else { // Jump to a position where it is guaranteed that we will
                    // either find a dominant pair or we will have to jump again if number of 0's increased
                    j = j + (count0 * count0) - count1 - 1;
                }
            }
        }
        return ans;
    }
}
