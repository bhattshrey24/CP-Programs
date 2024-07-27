import java.util.*;

public class Dummy {
    public static void main(String args[]) {
        System.out.println();

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

}
