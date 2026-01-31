import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    List<List<Integer>> res;
    boolean[][] pacific; 
    boolean[][] atlantic;

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = new ArrayList<>();
        int m=heights.length;
        int n = heights[0].length;

        pacific=new boolean[m][n];
        atlantic=new boolean[m][n];

        for(int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(i==0||j==0) {
                    dfs(heights, i, j, pacific);
                } 
                if (i==m-1||j==n-1) {
                    dfs(heights, i, j, atlantic);
                }
            }
        }
        for(int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited) {
        int m=heights.length;
        int n = heights[0].length;

        visited[i][j]=true;

        for (int k=0;k<4;k++) {
            int nx = i+dir[k][0];
            int ny = j+dir[k][1];
            if (nx>=0&&ny>=0&&nx<m&&ny<n&&visited[nx][ny]==false
            &&heights[nx][ny]>=heights[i][j]) {
                
                dfs(heights, nx, ny, visited);
            }
        }

    }
}
