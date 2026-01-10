class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res=[]
        for i in range(len(nums)-2):
            if i>0 and nums[i]==nums[i-1]:
                continue
            diff=0-nums[i]
            j=i+1
            k=len(nums)-1

            while j<k:
                sum1=nums[j]+nums[k]
                if sum1<diff:
                    j+=1
                elif sum1>diff:
                    k-=1
                else:
                    res.append((nums[i],nums[j], nums[k]))
                    j+=1
                    k-=1
                    while  j<k and nums[j]==nums[j-1]:
                        j+=1
                    while  j<k and nums[k]==nums[k+1]:
                        k-=1
        
        return res