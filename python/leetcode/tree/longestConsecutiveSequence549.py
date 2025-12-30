class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def longestConsecutive(self, root: Optional[TreeNode]) -> int:
        #孙子的返回值 inc  dec
        self.total=0
        def dfs(node):
            if not node:
                return (0,0)
            inc=1
            dec=1

            leftInc, leftDec=dfs(node.left)
            rightInc, rightDec=dfs(node.right)

            if node.left:
                if node.left.val==node.val+1:
                    inc = max(inc, leftInc+1)
                elif node.left.val==node.val-1:
                    dec=max(dec, leftDec+1)

            if node.right:
                if node.right.val==node.val+1:
                    inc = max(inc, rightInc+1)
                elif node.right.val==node.val-1:
                    dec=max(dec, rightDec+1)

            self.total=max(self.total, inc+dec-1)

            return (inc, dec)

        dfs(root)
        return self.total
            