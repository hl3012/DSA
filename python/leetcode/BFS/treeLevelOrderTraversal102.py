class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue=deque()
        queue.append(root)
        res=[]
        while queue:
            size = len(queue)
            temp=[]
            for i in range(size):
                node = queue.popleft()
                if node:
                    temp.append(node.val)
                    queue.append(node.left)
                    queue.append(node.right)
            if temp:
                res.append(temp)
        return res