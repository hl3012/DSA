from typing import List
import math

class Solution(object):
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def can_finish(k: int)->bool:
            hours=0
            for pile in piles:
                hours+=math.ceil(pile/k)
            return hours<=h
        
        left=1
        right=max(piles)
        while left<right:
            mid=left+(right-left)//2
            if can_finish(mid):
                right=mid
            else:
                left=mid+1
        return left
    
    
piles = [30,11,23,4,20]
h = 6
s=Solution()
print(s.minEatingSpeed(piles, h))
        
        