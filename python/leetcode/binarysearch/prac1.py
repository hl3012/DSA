#[-5,-2,1,3,5]  严格递增数组
# 0,  1,2,3,4  index
#找到下标i 满足nums[i]=i
class Solution:
    def searchIndex(self, nums):
        left=0
        right=len(nums)-1
        while left<=right:
            mid = left+(right-left)//2
            if(nums[mid]<mid):
                left=mid+1
            elif(nums[mid]>mid):
                right=mid-1
            else:
                return mid
        
        return -1

nums = [-5,-2, 1, 3, 5]
s=Solution()
print(s.searchIndex(nums))