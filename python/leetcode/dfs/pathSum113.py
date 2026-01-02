class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res=[]

        def dfs(node, path, currSum):
            if not node:
                return
            
            path.append(node.val)
            currSum+=node.val

            if currSum==targetSum and not node.left and not node.right:
                res.append(path+[])
                
            
            dfs(node.left, path, currSum)
            dfs(node.right, path, currSum)
            path.pop()
        
        dfs(root, [], 0)
        return res