class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res=[]
        used=[False for _ in range(len(nums))]

        def dfs(path, used):
            if len(path)==len(nums):
                res.append(path+[])
                return
            
            for i in range(len(nums)):
                if used[i]==True:
                    continue
                
                if i>0 and nums[i]==nums[i-1] and used[i-1]==False:
                    continue
                
                path.append(nums[i])
                used[i]=True
                dfs(path, used)
                used[i]=False
                path.pop()


        dfs([],used)
        return res
                