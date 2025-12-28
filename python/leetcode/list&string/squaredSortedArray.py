from typing import List
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        # i=0
        # n=len(nums)
        # while i<n:
        #     nums[i]*=nums[i]
        #     i+=1
        # nums.sort()
        # return nums

        n=len(nums)
        left=0
        right=n-1
        k=n-1
        res=[0]*n
        while left<=right:
            if nums[left]*nums[left]<nums[right]*nums[right]:
                res[k]=nums[right]*nums[right]
                k-=1
                right-=1
            else:
                res[k]=nums[left]*nums[left]
                k-=1
                left+=1    
        return res
    
        n=len(nums)
        left, right=0, n-1
        res=[]
        while left<=right:
            if abs(nums[left])<abs(nums[right]):
                res.append(nums[right]**2)
                right-=1
            else:
                res.append(nums[left]**2)
                left+=1
        return res[::-1]
