class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        visited=set()
        curr= head
        

        while curr:
            if curr in visited:
                return True
            else:
                visited.add(curr)
            curr=curr.next
        return False
    
    