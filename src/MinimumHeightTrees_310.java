import javax.swing.text.DefaultEditorKit;
import javax.swing.tree.TreeNode;
import java.util.*;

// O(V+E)
public class MinimumHeightTrees_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new LinkedList<Integer>();
        if (edges.length == 0 || edges[0].length == 0 || n == 0)
           res.add(0);
        else {
            int[] degree = new int[n];

            List<List<Integer>> neighbours = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++)
                neighbours.add(new ArrayList<>());

            for (int[] edge: edges) {
                neighbours.get(edge[0]).add(edge[1]);
                neighbours.get(edge[1]).add(edge[0]);
                degree[edge[0]]++;
                degree[edge[1]]++;
            }
            List<Integer> iters = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1)
                    iters.add(i);
            }
            int remained = n;
            while (!iters.isEmpty() && remained > 2) {
                List<Integer> toIters = new LinkedList<Integer>();
                for (int node: iters) {
                    degree[node]--;
                    for (int neighbour : neighbours.get(node)) {
                        if (degree[neighbour] != -1) {
                            degree[neighbour]--;
                            if (degree[neighbour] == 1)
                                toIters.add(neighbour);
                        }
                    }
                    remained--;
                }
                iters = toIters;
            }
            res = iters;
        }
        return res;
    }
}