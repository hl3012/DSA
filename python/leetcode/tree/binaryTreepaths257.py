from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val=val
        self.left=left
        self.right=right
        
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res=[]
        
        def dfs(node, path):
            if not node:
                return
            path.append(node.val)
            if not node.left and not node.right:
                res.append("->".join(str(x) for x in path))
            else:
                dfs(node.left, path)
                dfs(node.right, path)
            path.pop()
            
        dfs(root, [])
        return res