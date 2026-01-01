class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def dfs(node):
            if not node:
                return (None, None)
                
            leftRoot, leftRight = dfs(node.left)
            rightRoot,rightRight =dfs(node.right)

            node.left=None

            if leftRoot:
                node.right=leftRoot
                leftRight.right =rightRoot
            else:
                node.right = rightRoot
            
            tail=rightRight or leftRight or node
            return (node, tail)
        
        #  def dfs(node):
        #     # if not node:
        #     #     return (None, None)
        #     if not node:
        #         return None
            
        #     leftNode = dfs(node.left)
        #     rightNode = dfs(node.right)

        #     if leftNode:
        #         leftNode.right = node.right
        #         node.right = node.left
        #         node.left=None
            
        #     return rightNode or leftNode or node

        dfs(root)
