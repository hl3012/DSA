import java.util.*;


class DSU {
    int[] parent, size;
    int comps;
    public DSU(int n) {
        comps=n;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<n;i++) {
            parent[i]=i;
            size[i]=i;
        }
    }
    public int find(int node) {
        if (parent[node]!=node) {
            parent[node]=find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu=find(u), pv=find(v);
        if(pu==pv) return false;
        if(size[pu]<size[pv]) {
            int temp = pu;
            pu=pv;
            pv=temp;
        }
        comps--;
        size[pu]+=size[pv];
        parent[pv]=pu;
        return true;
    }

    public int components() {
        return comps;
    }

}

public class GraphValidtree {
    List<List<Integer>> adj;
    Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        if (m>n-1) return false;

        DSU dsu = new DSU(n);
        for(int[] e: edges) {
            if(!dsu.union(e[0],e[1])){
                return false;
            }
        }
        return dsu.components()==1;

        // adj = new ArrayList<>();
        // visited = new HashSet<>();


        // for (int i=0;i<n;i++) {
        //     adj.add(new ArrayList<>());
        // }

        // for (int[] e: edges) {
        //     int curr = e[0];
        //     int next = e[1];
        //     adj.get(curr).add(next);
        //     adj.get(next).add(curr);
    }

    //     if(!dfs(0,-1)) {
    //         return false;
    //     }
        
    //     return visited.size()==n;
    // }

    // private boolean dfs(int node,int parent) {
    //     if(visited.contains(node)) return false;
    //     visited.add(node);
    //     for (int n: adj.get(node)) {
    //         if (n==parent) continue;
    //         if (!dfs(n, node)) return false;
    //     }
    //     return true;
    //     Queue<int[]> q = new LinkedList<>();
    //     q.offer(new int[]{0,-1});
    //     visited.add(0);
    //     while(!q.isEmpty()) {
    //         int[] c = q.poll();
    //         int node = c[0];
    //         int parent = c[1];
    //         for (int i: adj.get(node)) {
    //             if (i==parent) continue;
    //             if(visited.contains(i)) return false;
    //             visited.add(i);
    //             q.offer(new int[]{n,node});
    //         }
    //     }
    //     return visited.size()==n;

} 
