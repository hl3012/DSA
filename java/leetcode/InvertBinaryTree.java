class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){this.val=val;}
}


public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root!=null) {
            TreeNode left=invertTree(root.left);
            TreeNode right=invertTree(root.right);
            root.left=right;
            root.right=left;
        }
        return root;
    }
}
