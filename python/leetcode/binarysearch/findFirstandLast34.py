#sorted 
#first, last
class Solution:
    def searchRange(self, nums, target):
        if(not nums): #空集，not x: []. {}, (), set(),"",0,0.0,None, False
            return [-1, -1]
        left = self.searchFirst(nums, target)
        right = self.searchLast(nums, target)
        return [left, right]
    
    #5,7,8,8,9
    #0,1,2,3,4
    #mid=2 nums[2]=8
    def searchFirst(self, nums, target):
        start=0
        end=len(nums)-1
        res=-1
        while(start<=end):
            mid=start+(end-start)//2
            if(nums[mid]>target):
                end=mid-1
            elif(nums[mid]<target):
                start=mid+1
            else:
                res=mid
                end=mid-1
        return res
    
    def searchLast(self, nums, target):
        start=0
        end=len(nums)-1
        res=-1
        while(start<=end):
            mid=start+(end-start)//2
            if(nums[mid]>target):
                end=mid-1
            elif(nums[mid]<target):
                start=mid+1
            else:
                res=mid
                start=mid+1
        return res

nums = [5,7,7,8,8,10]
target = 8
s=Solution()
print(s.searchRange(nums, target))