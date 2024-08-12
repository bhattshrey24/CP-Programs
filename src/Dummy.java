import java.util.*;

public class Dummy {
    public static void main(String args[]) {

    }

    public int countGoodNodes(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        int[] count = new int[1];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            ArrayList<Integer> children;
            if (tree.containsKey(u)) {
                children = tree.get(u);
            } else {
                children = new ArrayList<>();
            }
            children.add(v);
            tree.put(u, children);

            ArrayList<Integer> children2;
            if (tree.containsKey(v)) {
                children2 = tree.get(v);
            } else {
                children2 = new ArrayList<>();
            }
            children2.add(u);
            tree.put(v, children2);
        }
        findSizeRec(0, -1, tree, count);
        return count[0];
    }

    public static int findSizeRec(int currNode, int parent, HashMap<Integer, ArrayList<Integer>> tree, int[] count) {
        ArrayList<Integer> child = tree.get(currNode);
        if (child.size() == 1 && child.get(0) == parent) {
            count[0]++;
            return 1;
        }

        int totalSize = 0;
        boolean isFoundMisMatch = false;
        int prev = -1;

        for (int children : tree.get(currNode)) {
            if (children == parent) {
                continue;
            }
            int size = findSizeRec(children, currNode, tree, count);
            totalSize += size;

            if (prev == -1) {
                prev = size;
            } else if (prev != size) {
                isFoundMisMatch = true;
            }
        }

        if (!isFoundMisMatch) {
            count[0]++;
        }
        return totalSize;
    }


}