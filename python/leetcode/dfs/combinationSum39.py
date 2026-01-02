class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res=[]

        def dfs(startIndex, path, currSum):
            if currSum==target:
                res.append(path+[])
                return
            if currSum>target:
                return
            for i in range(startIndex,len(candidates)):
                path.append(candidates[i])
                dfs(i, path, currSum+candidates[i])
                path.pop()


        dfs(0,[], 0)
        return res