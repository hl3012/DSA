import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // if (root==null) return new ArrayList<>();
        // Queue<TreeNode> q = new LinkedList<>();
        // q.offer(root);
        // List<List<Integer>> res = new ArrayList<>();
        // while (!q.isEmpty()) {
        //     int size = q.size();
        //     List<Integer> path = new ArrayList<>();
        //     for (int i=0;i<size;i++) {
        //         TreeNode node = q.poll();
        //         path.add(node.val);
        //         if (node.left!=null) {
        //             q.offer(node.left);
        //         } 
        //         if (node.right!=null) {
        //             q.offer(node.right);
        //         } 
        //     }
        //     res.add(path);
        // }
        // return res;
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node==null) return;
        if(res.size()==depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }

}
