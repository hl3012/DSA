class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res=[]
        used=[False for _ in range(len(nums))]

        def dfs(path, used):
            if len(path)==len(nums):
                res.append(path+[])
                return
            
            for i in range(len(nums)):
                if used[i]==True:
                    continue
                path.append(nums[i])

                used[i]=True

                dfs(path, used)
                used[i]=False
                path.pop()

        dfs([],used)
        return res
