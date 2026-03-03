import java.util.*;

class DSU {
    private int[] Parent, Size;
    public DSU(int n) {
        Parent = new int[n+1];
        Size=new int[n+1];
        for(int i=0;i<=n;i++) {
            Parent[i]=i;
            Size[i]=1;
        }
    }

    public int find(int node) {
        if(node!=Parent[node]) {
            Parent[node]=find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu=find(u);
        int pv=find(v);
        if(pu==pv) return false;
        if(Size[pu]>=Size[pv]) {
            Size[pu]+=Size[pv];
            Parent[pv]=pu;
        } else {
            Size[pv]+=Size[pu];
            Parent[pu]=pv;
        }
        return true;
    }
}

public class NumberofIsland {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
    //     if(grid==null||grid.length==0) return 0;
        int count=0;
        int rows = grid.length;
        int cols=grid[0].length;
        DSU dsu = new DSU(rows*cols);


        for (int i=0; i<rows;i++) {
            for (int j=0; j<cols;j++) {
                if (grid[i][j]=='1') {
    //                 bfs(grid, i, j);
    //                 count++;
                    count++;
                    for(int[] dir : dirs) {
                        int nx=i+dir[0];
                        int ny=j+dir[1];
                        if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == '1') {
                            if(dsu.union(i*cols+j,nx*cols+ny)) {
                                count--;
                            }
                        }
                    }
                }

            }

        }
        return count;
    // }

    // private void bfs(char[][] grid, int i, int j) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     Queue<int[]> queue = new LinkedList<>();
    //     queue.offer(new int[]{i, j});
    //     grid[i][j]='0';
    //     while (!queue.isEmpty()) {
    //         int[] newXY = queue.poll();
    //         int x = newXY[0];
    //         int y = newXY[1];
    //         for (int[] dir: dirs) {
    //             int nx = x+dir[0];
    //             int ny=y+dir[1];
    //             if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
    //                 queue.offer(new int[]{nx, ny});
    //                 grid[nx][ny]='0';
    //             }
    //         }
    //     }
        
    }
}
