from typing import List

# sorted arry ascending order
# unique

class Solution:
    def search(self, nums: List[int], target: int)->int:
        left = 0
        right = len(nums) -1
        while(left<=right):
            mid = left + ((right-left)//2)
            if(nums[mid] == target):
                return mid
            elif(nums[mid] > target):
                right = mid-1
            else:
                left = mid+1
        return -1
    
    def search2(self, nums: List[int], target: int)->int:
        left = 0
        right = len(nums)
        while(left<right):
            mid = left + ((right-left)//2)
            if(nums[mid] == target):
                return mid
            elif(nums[mid] > target):
                right = mid
            else:
                left = mid+1
        return -1


nums = [-1, 0, 3, 5, 9, 12]
target = 9
s=Solution()
result = s.search2(nums, target)
print(result)