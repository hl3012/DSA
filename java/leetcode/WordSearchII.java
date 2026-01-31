import java.util.*;
class TriesNode {
    Map<Character, TriesNode> children = new HashMap<>();
    boolean isEnd = false;

    public void addWord(String word) {
        TriesNode curr = this;
        for (char c: word.toCharArray()) {
            curr.children.putIfAbsent(c, new TriesNode());
            curr = curr.children.get(c);
        }
        curr.isEnd=true;
    }
}


public class WordSearchII {
    Set<String> res;
    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        TriesNode root = new TriesNode();
        for (String word: words) {
            root.addWord(word);
        }

        int rows = board.length, cols = board[0].length;
        res = new HashSet<>();
        visited = new boolean[rows][cols];
        for(int r=0;r<rows;r++) {
            for (int c=0;c<cols;c++) {
                dfs(board, r, c, root, "");
            }
        }
        return new ArrayList<>(res);
    }
    private void dfs(char[][] board, int r, int c, TriesNode node, String word) {
        int rows = board.length, cols = board[0].length;
        if (r<0||c<0||r>=rows||c>=cols||visited[r][c]==true||!node.children.containsKey(board[r][c])) {
            return;
        }
        visited[r][c]=true;
        node = node.children.get(board[r][c]);
        word+=board[r][c];
        if (node.isEnd) {
            res.add(word);
        }
        dfs(board, r+1,c,node,word);
        dfs(board, r-1,c,node,word);
        dfs(board, r,c+1,node,word);
        dfs(board, r,c-1,node,word);
        visited[r][c]=false;
    }
}
