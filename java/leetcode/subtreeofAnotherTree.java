public class subtreeofAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root==null&&subRoot==null) return true;
        if(root==null) return false;
        boolean res =sameTree.isSameTree(root, subRoot);
        if (res) return true;
        return sameTree.isSameTree(root.left, subRoot)||sameTree.isSameTree(root.right, subRoot);;
    }
}
