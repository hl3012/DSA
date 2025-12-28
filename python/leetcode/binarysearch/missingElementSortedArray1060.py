from typing import List

class Solution:
    def missingElement(self, nums: List[int], k: int) -> int:        
        n=len(nums)
        def missing(i):
            return nums[i]-nums[0]-i
        
        if k>missing(n-1):
            return nums[n-1]+k-missing(n-1)
        
        left=0
        right=n-1
        while(left<right):
            mid=left+(right-left)//2
            if(missing(mid)<k):
                left=mid+1
            else:
                right=mid
        return nums[left-1]+k-missing(left-1)