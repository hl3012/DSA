from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val=val
        self.left=left
        self.right=right
        
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res=[]
        if not root:
            return res
        
        res+= self.inorderTraversal(root.left)
        res.append(root.val)
        res+=self.inorderTraversal(root.right)
        return res