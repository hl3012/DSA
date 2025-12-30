class Solution:
    def maximumAverageSubtree(self, root: Optional[TreeNode]) -> float:
        self.maxAvg=float("-inf")

        def dfs(node):
            if not node:
                return (0, 0)
            leftSum, leftCount=dfs(node.left)
            rightSum, rightCount=dfs(node.right)

            totalSum = node.val + leftSum + rightSum
            totalCount = 1 + leftCount + rightCount

            self.maxAvg = max(self.maxAvg, totalSum / totalCount)

            return totalSum, totalCount
        
        dfs(root)
        return self.maxAvg