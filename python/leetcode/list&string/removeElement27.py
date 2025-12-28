class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        # i=0
        # n=len(nums)
        # while(i<n):
        #     if nums[i]==val:
        #         for j in range(i+1, n):
        #             nums[j-1]=nums[j]
        #         n-=1
        #     else:
        #         i+=1
        # return n


        # slowIndex=0
        # fastIndex=0
        # n=len(nums)
        # while(fastIndex<n):
        #     if val!=nums[fastIndex]:
        #         nums[slowIndex]=nums[fastIndex]
        #         slowIndex+=1
        #     fastIndex+=1
        # return slowIndex

        left=0
        right = len(nums)-1
        while(left<=right):
            while left<=right and val!=nums[left]:
                left+=1
            while left<=right and val==nums[right]:
                right-=1

            if left<right:
                nums[left]=nums[right]
                left+=1
                right-=1
        
        return left