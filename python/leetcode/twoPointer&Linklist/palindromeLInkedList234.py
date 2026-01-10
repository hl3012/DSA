class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        res=[]
        curr=head
        while curr:
            res.append(curr.val)
            curr=curr.next
        
        return res==res[::-1]
    
    
        if not head or not head.next:
            return True


        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        
        def reverseLinkedList(node):
            pre=None
            curr=node

            while curr:
                temp=curr.next
                curr.next=pre
                pre=curr
                curr=temp

            return pre

        
        fast = reverseLinkedList(slow)
        slow = head
        while fast:
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast=fast.next
        return True
