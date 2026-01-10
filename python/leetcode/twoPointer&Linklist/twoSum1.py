class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map1={}

        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in map1:
                return [i, map1.get(diff)]
            else:
                map1[nums[i]]=i

        return []
    #     nums_with_idx = [(num, i) for i, num in enumerate(nums)]
    #     nums_with_idx.sort()
    #     left=0
    #     right=len(nums)-1

    #     while left < right:
    #         s = nums_with_idx[left][0] + nums_with_idx[right][0]
    #         if s > target:
    #             right -= 1
    #         elif s < target:
    #             left += 1
    #         else:
    #             return [nums_with_idx[left][1], nums_with_idx[right][1]]

    #     return []