class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        #height, isBalanced
        def dfs(node):
            if not node:
                return (0, True)
            leftHeight, leftBalanced=dfs(node.left)
            rightHeight, rightBalanced=dfs(node.right)
            balanced = abs(leftHeight-rightHeight)<=1 and leftBalanced and rightBalanced
            height=max(leftHeight, rightHeight)+1
            return (height, balanced)

        height, balanced= dfs(root)
        return balanced