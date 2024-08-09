import java.util.*;

public class Dummy {
    public static void main(String args[]) {

    }

    public boolean validTree(int n, int[][] edges) {

        if (n == 1) return true; // edge case handling

        if (edges.length != (n - 1)) { // We know that a Spanning Tree with n vertices
            // will have exactly n - 1 edges
            return false;
        }

        int[] parent = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        makeSet(parent);

        boolean ans = true;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (findLeader(u, parent) == findLeader(v, parent)) { // this means
                // cycle detected
                return false;
            } else {
                union(u, v, parent, rank);
            }
        }
        return ans;
    }

    public static void makeSet(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public static int findLeader(int x, int[] parent) {
        if (parent[x] == x) return x;
        int leader = findLeader(parent[x], parent);
        parent[x] = leader;
        return leader;
    }

    public static void union(int u, int v, int[] parent, int[] rank) { // rank is nothing but height
        int leaderU = findLeader(u, parent);
        int leaderV = findLeader(v, parent);
        if (leaderV != leaderU) {
            if (rank[leaderU] > rank[leaderV]) {
                parent[leaderV] = leaderU;
            } else if (rank[leaderU] < rank[leaderV]) {
                parent[leaderU] = leaderV;
            } else { // when height is same
                parent[leaderU] = leaderV;
                rank[leaderV]++;
            }
        }
    }
    
}