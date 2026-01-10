class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
            pre=None
            curr=head

            while curr:
                temp= curr.next
                curr.next=pre
                pre=curr
                curr=temp

            return pre