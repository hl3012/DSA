import java.util.LinkedList;
import java.util.Queue;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, long left, long right) {
        if (node ==null) return true;
        if (!(left<node.val&&node.val<right)) return false;
        return valid(node.left, left, node.val) && valid(node.right, node.val, right);
        // if (root == null) return true;
        // Queue<Object[]> queue=new LinkedList<>();
        // queue.offer(new Object[]{root, Long.MIN_VALUE, Long.MAX_VALUE});

        // while (!queue.isEmpty()) {
        //     Object[] curr = queue.poll();
        //     TreeNode node = (TreeNode) curr[0];
        //     long left = (long) curr[1];
        //     long right = (long) curr[2];

        //     if (!(left<node.val&&node.val<right)) return false;
        //     if (node.left != null) {
        //         queue.offer(new Object[]{node.left, left, (long) node.val});
        //     }
        //     if (node.right != null) {
        //         queue.offer(new Object[]{node.right, (long) node.val, right});
        //     }
        // }
        // return true;
    }
}
