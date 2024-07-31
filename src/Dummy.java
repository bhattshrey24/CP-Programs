import java.util.*;

public class Dummy {
    public static void main(String args[]) {
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // The concept is simple : We just have to find if a cycle exist in the given graph.
        // We will use Kahns algo to find cycle
        // Note : It is not guaranteed that prerequisite will have all the courese
        // i.e. eg :- numCourses = 7 and prerequisites = [[2,0],[1,4]]. So you see not all vertices have edges
        // from 0 to 6 so we will simply consider such vertexes which do not have an edge as an
        // independent vertex and they will not affect our answer because they do not have a parent or children
        // but we will still count them just because it's easy to code that way otherwise we can ignore such
        // vertexes too by making indegree as Set instead of array and only include vertices which are there in grf

        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) { // Making graph from given
            // edges (i.e. prerequisites) and also indegree array at the same time
            int source = pair[1];
            int destination = pair[0];
            if (adj[source] == null) adj[source] = new ArrayList<>();
            adj[source].add(destination);
            indegree[destination]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int currVertex = queue.remove();
            count++;
            if (adj[currVertex] != null) { // checking this because of this
                // case :- numCourses = 7 and prerequisites = [[2,0],[1,4]] as mentioned above
                // i.e. not every vertex will have an edge for every testcase. So only add
                // children if they are present
                for (int neighbor : adj[currVertex]) {
                    indegree[neighbor] -= 1;
                    if (indegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return count == numCourses;// We find a cycle if all nodes are not
        // traversed after kahns algo. so if count!=numCourses then it means cycle is present
    }

            public int[] findOrder(int numCourses, int[][] prerequisites) {
                List<Integer>[] adj = new List[numCourses];
                int[] indegree = new int[numCourses];

                for (int[] pair : prerequisites) {
                    int source = pair[1];
                    int destination = pair[0];
                    if (adj[source] == null) adj[source] = new ArrayList<>();
                    adj[source].add(destination);
                    indegree[destination]++;
                }

                Queue<Integer> queue = new LinkedList<>();
                for (int i = 0; i < numCourses; i++) {
                    if (indegree[i] == 0) {
                        queue.add(i);
                    }
                }
                ArrayList<Integer> ans = new ArrayList<>();
                int count = 0;
                while (!queue.isEmpty()) {
                    int currVertex = queue.remove();
                    count++;
                    ans.add(currVertex);
                    if (adj[currVertex] != null) {
                        for (int neighbor : adj[currVertex]) {
                            indegree[neighbor] -= 1;
                            if (indegree[neighbor] == 0) {
                                queue.add(neighbor);
                            }
                        }
                    }
                }
                if (count!=numCourses) return new int[0]; // i.e. when there is a cycle present

                int[] arr = new int[ans.size()]; // Just converting arrayList to array
                for (int i = 0; i < ans.size(); i++) arr[i] = ans.get(i);

                return arr;
            }

}
