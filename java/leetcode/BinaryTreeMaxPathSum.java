public class BinaryTreeMaxPathSum {
    int max= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       dfs(root);
       return max;
    }

    private int dfs(TreeNode root) {
        if (root==null) return 0;
        int leftMax= Math.max(maxPathSum(root.left), 0);
        int rightMax= Math.max(maxPathSum(root.right),0);
        max=Math.max(leftMax+rightMax+root.val, max);
        return root.val+Math.max(leftMax, rightMax);
    }
}
