class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res=[]

        def dfs(startIndex, path, currSum):
            if len(path)==k and currSum==n:
                res.append(path+[])
                return
            
            if len(path)>k or currSum>n:
                return
            
            for i in range(startIndex, 9-(k-len(path))+1):   #9-i+1>=(k-len(path))
                path.append(i)
                dfs(i+1, path, currSum+i)
                path.pop()
            
        dfs(1, [], 0)
        return res