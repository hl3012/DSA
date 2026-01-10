class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:

        # def partition(start, end):

        #     p = random.randint(start, end)
        #     nums[p], nums[end] = nums[end], nums[p]
        #     pivot=nums[end]
        #     i = start - 1 
        #     for j in range(start, end):
        #         if nums[j] <= pivot:
        #             i += 1
        #             nums[i], nums[j] = nums[j], nums[i]
        #     nums[i+1], nums[end] = nums[end], nums[i+1]
        #     return i + 1
     
        # def quickSort(start, end):
        #     if start>=end:
        #         return

        #     idx = partition(start, end)
        #     quickSort(start, idx-1)
        #     quickSort(idx+1, end)
        
        # quickSort(0,  len(nums)-1)
        # return nums

        def quicksort(l, r):
            if l >= r:
                return

            p = random.randint(l, r)
            pivot = nums[p]

            lt = l
            i = l
            gt = r

            while i <= gt:
                if nums[i] < pivot:
                    nums[lt], nums[i] = nums[i], nums[lt]
                    lt += 1
                    i += 1
                elif nums[i] > pivot:
                    nums[i], nums[gt] = nums[gt], nums[i]
                    gt -= 1
                else:
                    i += 1

            quicksort(l, lt - 1)
            quicksort(gt + 1, r)

        quicksort(0, len(nums) - 1)
        return nums