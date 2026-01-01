class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        queue=deque()
        queue.append(root)
        res=[]
        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                if i==size-1:
                    res.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return res