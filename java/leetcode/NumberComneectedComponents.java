import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberComneectedComponents {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int res =0;
        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                bfs(adj, visit, node);
                res++;
            }
        }
        return res;
    }

    private void bfs(List<List<Integer>> adj, boolean[] visit, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : adj.get(cur)) {
                if (!visit[nei]) {
                    visit[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }
}
