class Solution:
    def searchInsert(self, nums, target):
        #0,1,3,4,5
        #2->2
        #3->2
        #4->3
        #5->4
        left=0
        right=len(nums)-1
        while(left<=right):
            mid=left+(right-left)//2
            if(nums[mid]<target):
                left=mid+1
            elif(nums[mid]>target):
                right=mid-1
            else:
                return mid
        return left
        
        
    
nums = [1,3,5,6]
target = 2
s=Solution()
print(s.searchInsert(nums, target))
