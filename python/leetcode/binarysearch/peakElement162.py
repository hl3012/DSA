class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(not nums):
            return -1
        left=0
        right=len(nums)-1
        while(left<right):
            mid=left+(right-left)//2
            if(nums[mid]<=nums[mid+1]):
                left=mid+1
            elif(nums[mid]>nums[mid+1]):
                right=mid
        return left

nums = [1,2,1,3,5,6,4]
s=Solution()
print(s.findPeakElement(nums))
