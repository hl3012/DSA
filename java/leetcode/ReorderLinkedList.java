public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode second = slow.next;
        slow.next=null;

        ListNode newSecond = reverse(second);

        ListNode first = head;
        while (newSecond !=null) {
            ListNode temp1=first.next;
            ListNode temp2=newSecond.next;

            first.next=newSecond;
            newSecond.next=temp1;

            first=temp1;
            newSecond=temp2;
        }
    }
}
