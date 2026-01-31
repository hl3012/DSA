public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++) {
            for (int j =0; j<n;j++) {
                if(dfs(board, word, i, j, visited, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited, int idx) {
        if(idx==word.length()) return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(idx) || visited[i][j]==true) return false; 
        visited[i][j]=true;
        boolean found = dfs(board,word,i+1,j,visited,idx+1)||
                        dfs(board,word,i-1,j,visited,idx+1)||
                        dfs(board,word,i,j+1,visited,idx+1)||
                        dfs(board,word,i,j-1,visited,idx+1);
        visited[i][j]=false;
        return found;
    }
}
