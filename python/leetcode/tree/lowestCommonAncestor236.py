class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        #count p, q & ancestor
        def dfs(node):
            if not node:
                return (0, None)
            leftCount, leftAnc = dfs(node.left)
            rightCount, rightAnc=dfs(node.right)
            
            if leftCount==2:
                return (2, leftAnc)
            if rightCount==2:
                return (2, rightAnc)
                
            selfCount=0
            if node==p or node==q:
                selfCount+=1
            total=selfCount+leftCount+rightCount
            if total==2:
                return (2, node)
            if total==1:
                return (1, None)
            return (0, None)
        count, anc= dfs(root)
        return anc