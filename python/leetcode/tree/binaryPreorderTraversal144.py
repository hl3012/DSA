from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val=val
        self.left=left
        self.right=right
        
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # res=[]
        # if not root:
        #     return res
        # res.append(root.val)
        # res+= self.preorderTraversal(root.left)
        # res+=self.preorderTraversal(root.right)
        # return res

        if not root:
            return []

        res = []
        stack = [root]

        while stack:
            node = stack.pop()
            res.append(node.val)

            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)

        return res
    
    
root = TreeNode(10)
root.left=TreeNode(None)
root.right=TreeNode(12)

s=Solution()
print(s.preorderTraversal(root))