import java.util.Stack;

public class kthNodeinBST {
    // boolean stop=false;
    public int kthSmallest(TreeNode root, int k) {
    //     int[] temp=new int[2];
    //     temp[0]=k;
    //     dfs(root, temp);
    //     return temp[1];
    // }

    // private void dfs(TreeNode node, int[] temp) {
    //     if (node==null || stop==true) return;
    //     dfs(node.left, temp);
    //     temp[0]--;
    //     if (temp[0]==0) {
    //         temp[1]=node.val;
    //         stop=true;
    //         return;
    //     }      
    //     dfs(node.right, temp);

        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;

        while (!st.isEmpty() || curr!=null) {
            while (curr!=null) {
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            if(--k==0) return curr.val;
            curr=curr.right;
        }
        return -1;

    }
}
