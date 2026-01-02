class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res=[]

        def dfs(startIndex, path):
            res.append(path+[])
        
            for i in range(startIndex,len(nums)):
                if i>startIndex and nums[i]==nums[i-1]:
                    continue
         
                path.append(nums[i])
                dfs(i+1, path)
                path.pop()
          
                    

        dfs(0,[])
        return res