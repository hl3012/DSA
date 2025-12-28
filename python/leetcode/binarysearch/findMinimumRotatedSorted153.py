class Solution(object):
    def findMin(self, nums):
        left=0
        right=len(nums)-1
        #left =0, right = 2  mid=1, nums[1]=1<nums[2]=2
        #right=0
        while(left<right):
            mid = left+(right-left)//2
            if(nums[mid]>nums[right]):
                left=mid+1
            elif(nums[mid]<=nums[right]):
                right=mid
        return nums[left]