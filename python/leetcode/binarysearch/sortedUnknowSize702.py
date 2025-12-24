# sorted unique size unknown

# class ArrayReader:
#    def get(self, index: int) -> int:


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        MAX = 2**31-1
        left = 0
        right = 1
        while (reader.get(right)<target):
            left = right
            right = right *2
        while (left<=right):
            mid = left + (right - left)// 2
            if(reader.get(mid)>target):
                right = mid - 1
            elif(reader.get(mid)<target):
                left = mid + 1
            else:
                return mid
        return -1