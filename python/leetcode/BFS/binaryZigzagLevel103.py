class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        queue=deque()
        queue.append(root)
        res=[]

        leftToRight=True

        while queue:
            size = len(queue)
            temp=deque()

            for i in range(size):
                node = queue.popleft()
                if leftToRight:
                    temp.append(node.val)
                else:
                    temp.appendleft(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            res.append(list(temp))
            leftToRight = not leftToRight

        return res