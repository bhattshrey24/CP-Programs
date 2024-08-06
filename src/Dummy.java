import java.util.*;

public class Dummy {
    public static void main(String args[]) {
    }


    public int minFlips(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int countRow = 0;
        int countCol = 0;
        StringBuilder sb;
        int count1 = 0;
        for (int i = 0; i < r; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                sb.append(grid[i][j]);
                if (grid[i][j] == 1) {
                    count1++;
                }
            }
            countRow = countRow + palindromeCount(sb.toString());
        }
        for (int i = 0; i < c; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                sb.append(grid[j][i]);
            }
            countCol = countCol + palindromeCount(sb.toString());
        }
        int ans1 = countRow + Math.min((count1 + countRow) % 4, (count1 - countRow) % 4);
        int ans2 = countCol + Math.min((count1 + countCol) % 4, (count1 - countCol) % 4);

        return Math.min(ans1, ans2);
    }

    public static int palindromeCount(String str) {
        int i = 0;
        int j = str.length() - 1;
        int count = 0;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                count++;
            }
            i++;
            j--;
        }
        return count;
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        if (graph == null) { //This handles [[APES] , [APE]] case
            return "";
        }
        return topologicalSorting(graph); // Using kahns algo
    }


    private Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        // create nodes
        for (String word : words) { // every character of every word is converted to a vertex
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!graph.containsKey(ch)) {
                    graph.put(ch, new HashSet<Character>());
                }
            }
        }

        // create edges
        String prevWord = "";
        for (String currWord : words) {
            if (prevWord.equals("")) {
                prevWord = currWord;
                continue;
            }
            int currIdx = 0;
            while (currIdx < prevWord.length() && currIdx < currWord.length()) { // matching previous word and current word
                // till we get a mismatch or one of the string ends.
                char prevChar = prevWord.charAt(currIdx);
                char currChar = currWord.charAt(currIdx);
                if (prevChar != currChar) {
                    graph.get(prevChar).add(currChar); // adding the edge
                    break;
                }
                currIdx++;
            }

            if (currIdx == Math.min(prevWord.length(), currWord.length())) { // i.e. we have processed all characters of
                // the smaller string and still haven't found a mismatch.
                if (prevWord.length() > currWord.length()) {//This handles [[APES] , [APE]] case
                    return null;
                }
            }
            prevWord = currWord;
        }
        return graph;
    }

    private String topologicalSorting(Map<Character, Set<Character>> graph) {
        // NOTE : Since we should return the topological sort with lexicographical order
        // we should use PriorityQueue instead of a normal Queue
        Map<Character, Integer> indegree = getIndegree(graph);
        Queue<Character> queue = new PriorityQueue<>();

        for (Character ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character vertex = queue.remove();
            sb.append(vertex);
            for (Character neighbor : graph.get(vertex)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1); // decreasing the indegree of neighbor
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        if (sb.length() != indegree.size()) { // This means cycle was present
            // because of which we were not able to process all nodes
            return "";
        }
        return sb.toString();
    }

    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>(); // Simply creating indegree
        for (Character vertex : graph.keySet()) {
            indegree.put(vertex, 0); // adding 0 with every vertex of graph so that the vertices
            // with no incoming edges can also be added in the indegree array because their indegree is 0
        }
        for (Character vertex : graph.keySet()) {
            for (Character neighbor : graph.get(vertex)) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        return indegree;
    }




}