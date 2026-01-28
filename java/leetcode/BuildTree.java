import java.util.*;

public class BuildTree {
    int index=0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i=0; i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left>right) return null;
        if (preorder==null || preorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        int idx = map.get(root.val);
        root.left = dfs(preorder, left, idx-1);
        root.right = dfs(preorder, idx+1, right);
        return root;
    }
}
