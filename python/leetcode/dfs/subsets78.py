class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]
        
        def dfs(startIndex, path):
            res.append(path+[])
    
            for i in range(startIndex, len(nums)):
                path.append(nums[i])
                dfs(startIndex+1, path)
                path.pop()
        
        dfs(0,[])
        return res