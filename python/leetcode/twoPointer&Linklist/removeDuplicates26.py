class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0

        slow=1

        for fast in range(1, len(nums)):
            # if nums[slow]!=nums[fast]:  
            #     slow+=1  
            #     nums[slow]=nums[fast]   

            if nums[fast]!=nums[fast-1]:
                nums[slow]=nums[fast]
                slow+=1


        return slow
    
    
        slow=head
        fast=head

        while fast and fast.next:
            slow = slow.next
            fast=fast.next.next

            if slow==fast:
                return True

        return False