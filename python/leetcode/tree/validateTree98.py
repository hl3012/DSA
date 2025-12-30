class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def dfs(node, high, low):
            if not node:
                return True
            if not (low<node.val<high):
                return False
            return dfs(node.left, node.val, low) and dfs(node.right, high, node.val)

        return dfs(root, float("inf"), float("-inf"))
        